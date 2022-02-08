package com.filmes.filmes.services;

import java.util.List;

import com.filmes.filmes.entities.Filmes;

public interface IFilmesServices {
	
	public List<Filmes> findAll(String filmes, String diretor);
	public Filmes buscaPorId(Integer id);
	public Filmes cadastrarFilme(Filmes filmes);
	public void remove(Integer id);
	public void update(Filmes filmes);

}
