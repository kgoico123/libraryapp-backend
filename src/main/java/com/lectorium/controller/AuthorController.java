package com.lectorium.controller;

import com.lectorium.dto.AuthorDTO;
import com.lectorium.model.Author;
import com.lectorium.service.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final IAuthorService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> findAll() throws Exception{
        List<AuthorDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, AuthorDTO.class)).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> findById(@PathVariable("id") Integer id) throws Exception{
        AuthorDTO obj =  modelMapper.map(service.findById(id), AuthorDTO.class);
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> save(@RequestBody Author author) throws Exception{
        AuthorDTO obj =  modelMapper.map(service.save(author), AuthorDTO.class);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getIdAuthor()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> update(@PathVariable("id") Integer id, @RequestBody Author author) throws Exception{
        AuthorDTO obj = modelMapper.map(service.update(author, id), AuthorDTO.class);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id)
            throws Exception{
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
