package com.filmes.filmes.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
	
	public Filmes cadastrarFilme(final Filmes filmes) {
		
		if(filmes.getNota() < 1 || filmes.getNota() > 5) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Favor inserir um valor entre 1 - 5");
		}
		else if(filmes.getId() == null) {
			filmes.setId((filmesRepository.cont() + 1));
		}
		
		filmesRepository.cadastrarFilme(filmes);
		return filmes;
	}
	public void remove(Integer id) {
		filmesRepository.remove(id);
	}
	public void update(Filmes filmes) {
		filmesRepository.update(filmes);
	}

		
	


}
