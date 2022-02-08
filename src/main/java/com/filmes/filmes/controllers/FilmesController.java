package com.filmes.filmes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmes.filmes.entities.Filmes;
import com.filmes.filmes.repositories.FilmesRepository;
import com.filmes.filmes.services.FilmesServices;

@RestController
@RequestMapping("/filmes")
public class FilmesController {
	
	@Autowired
	FilmesServices filmesServices;
	
	@Autowired
	FilmesRepository filmesRepository;
	
	@PostMapping
	public ResponseEntity<Integer> post(@RequestBody final Filmes filmes){
		if(filmesRepository.findAll().stream().anyMatch(f -> f.getNome().equalsIgnoreCase(filmes.getNome())) &&
				filmesRepository.findAll().stream().anyMatch(f -> f.getDiretor().equalsIgnoreCase(filmes.getDiretor())))){
					throw new ResponseStatusException(HttpStatus.CONFLICT, "Ops. Este filme já esta cadastrado!");
				}
		filmesServices.cadastrarFilme(filmes);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

}
