package com.lectorium.service.impl;
import com.lectorium.repo.IComputadoraRepo;
import com.lectorium.repo.IGenericRepo;
import com.lectorium.service.IComputadoraService;
import org.springframework.stereotype.Service;
import com.lectorium.model.Computadora;


import lombok.RequiredArgsConstructor;
@Service
//@AllArgsConstructor
@RequiredArgsConstructor
public class ComputadoraService extends GenericService<Computadora, Integer> implements IComputadoraService {
	//@Autowired
	private final IComputadoraRepo repo;

	@Override
	protected IGenericRepo<Computadora, Integer> getRepo() {
		return repo;
    }

}
