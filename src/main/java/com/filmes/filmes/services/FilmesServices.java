package com.filmes.filmes.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filmes.filmes.entities.Filmes;
import com.filmes.filmes.repositories.FilmesRepository;

@Service
public class FilmesServices {

	@Autowired
	private FilmesRepository filmesRepository;
	
	public List<Filmes> findAll(String filmes, String diretor){
		if(filmes != null) {
			return filmesRepository.buscarFilmesPorNome(filmes);
		}else if(diretor != null) {
			return filmesRepository.buscarFilmesPorDiretor(diretor);
		}
		return filmesRepository.findAll();
	}
	
	public Filmes buscaPorId(Integer id) {
		return filmesRepository.buscaPorId(id);
	}
	
	public Filmes cadastrarFilme(Filmes filmes);
	public void remove(Integer id);
	public void update(Filmes filmes);

		
	


}
