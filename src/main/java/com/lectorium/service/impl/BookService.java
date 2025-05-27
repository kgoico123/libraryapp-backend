package com.lectorium.service.impl;

import org.springframework.stereotype.Service;

import com.lectorium.model.Book;
import com.lectorium.repo.IBookRepo;
import com.lectorium.repo.IGenericRepo;
import com.lectorium.service.IBookService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService extends GenericService<Book, Integer> implements IBookService {
    private final IBookRepo repo;

    @Override
    protected IGenericRepo<Book, Integer> getRepo() {
        return repo;
    }
}
