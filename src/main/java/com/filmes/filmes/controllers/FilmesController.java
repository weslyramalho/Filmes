package com.filmes.filmes.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filmes.filmes.entities.Filmes;
import com.filmes.filmes.services.FilmesServices;

@RestController
@RequestMapping("/filmes")
public class FilmesController {
	FilmesServices filmesServices = new FilmesServices();
	
	@PostMapping
	public ResponseEntity<Object> post(@RequestBody Filmes filmes){
		filmesServices.addNovoFilme(filmes);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

}
