package com.lectorium.service.impl;

import org.springframework.stereotype.Service;

import com.lectorium.model.Category;
import com.lectorium.repo.ICategoryRepo;
import com.lectorium.repo.IGenericRepo;
import com.lectorium.service.ICategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService extends GenericService<Category, Integer> implements ICategoryService {
    private final ICategoryRepo repo;

    @Override
    protected IGenericRepo<Category, Integer> getRepo() {
        return repo;
    }
}
