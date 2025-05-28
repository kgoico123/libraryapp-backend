package com.lectorium.controller;
import java.net.URI;
import java.util.List;

import com.lectorium.dto.ComputadoraDTO;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lectorium.model.Computadora;
import com.lectorium.service.IComputadoraService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

// https://localhost:8080/publishers
@RestController
@RequestMapping("/computadora")
//@AllArgsConstructor
@RequiredArgsConstructor

public class ComputadoraController {
private final IComputadoraService service;
	private final ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<List<ComputadoraDTO>> findAll() throws Exception{
		// ModelMapper modelMapper = new ModelMapper();
		//return service.findAll();
		//List<PublisherDTO> list = service.findAll().stream().map(e -> new PublisherDTO(e.getIdPublisher(), e.getName(), e.getAddress())).toList();
		//List<PublisherDTO> list = service.findAll().stream().map(e -> modelMapper.map(e, PublisherDTO.class)).toList();

		List<ComputadoraDTO> list = service.findAll().stream().map(this::converToDto).toList();

		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ComputadoraDTO> findById(@PathVariable("id") Integer id) throws Exception{
		//Publisher obj =  service.findById(id);
		//PublisherDTO obj = modelMapper.map(service.findById(id), PublisherDTO.class);
		ComputadoraDTO obj = converToDto(service.findById(id));
		return ResponseEntity.ok(obj);
	}

	@PostMapping
	public ResponseEntity<Void> save(@RequestBody ComputadoraDTO dto) throws Exception{
		//Publisher obj =  service.save(publisher);
		//Publisher obj = service.save(modelMapper.map(dto, Publisher.class));
		Computadora obj = service.save(convertToEntity(dto));
		//return ResponseEntity.ok(obj);
		System.out.println("save" + obj);

		// location: http://localhost:9090/publishers/{id}
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getIdComptadora()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<ComputadoraDTO> update(@PathVariable("id") Integer id, @RequestBody ComputadoraDTO dto) throws Exception{
		//Publisher obj =  service.update(modelMapper.map(dto,Publisher.class), id);
		//PublisherDTO dto1 = modelMapper.map(obj, PublisherDTO.class);
		//return ResponseEntity.ok(dto1);

		Computadora obj = service.update(convertToEntity(dto),id);
		ComputadoraDTO dto1= converToDto(obj);
		return ResponseEntity.ok(dto1);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id)
			throws Exception{
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("hateoas/{id}")
	public EntityModel<ComputadoraDTO> findByIdHateoas(@PathVariable("id") Integer id) throws Exception{
		Computadora obj = service.findById(id);
		EntityModel<ComputadoraDTO> resource = EntityModel.of(converToDto(obj));

		// Generar links informativos
		// localhost:9090/publishers/5
		WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).findById(id));
		WebMvcLinkBuilder link2 = linkTo(methodOn(this.getClass()).findAll());
		resource.add(link1.withRel("computadora-self-info"));
		resource.add(link2.withRel("computadora-all-info"));

		return resource;
	}

	private ComputadoraDTO converToDto(Computadora obj){
		return modelMapper.map(obj, ComputadoraDTO.class);
	}

	private Computadora convertToEntity(ComputadoraDTO dto){
		return modelMapper.map(dto, Computadora.class);
	}
}
