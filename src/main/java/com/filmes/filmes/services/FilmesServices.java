package com.filmes.filmes.services;

import java.util.ArrayList;
import java.util.List;

import com.filmes.filmes.entities.Filmes;

public class FilmesServices {

	private List<Filmes> filmesList;
	
	public FilmesServices() {
		this.filmesList = new ArrayList<>();
	}
	
	public List<Filmes> Filmes(String nome){
		return filmesList;
	}
	
	public void addNovoFilme(Filmes filmes) {
		boolean id = filmesList.stream().allMatch(f -> f.getId().equals(filmes));
		boolean nome = filmesList.stream().allMatch(f -> f.getNome().equals(filmes));
		boolean diretor = filmesList.stream().allMatch(f -> f.getDiretor().equals(filmes));
		boolean ano = filmesList.stream().allMatch(f -> f.getAno().equals(filmes));
		
		
		if(id && nome && diretor && ano == false) {
		
			filmesList.add(filmes);
			}
		}
	
		
	


}
