package com.filmes.filmes.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.filmes.filmes.entities.Filmes;

@Repository
public class FilmesRepository {
	private  final List<Filmes> filmesList;
	
	public FilmesRepository() {
		this.filmesList = new ArrayList<>();
	}
	
	public void cadastrarFilme(Filmes filmes) {
		this.filmesList.add(filmes);
		
	}
	
	public int cont() {
		return filmesList.size();
	}
	
	public void remove(Integer id) {
		filmesList.removeIf(i -> i.getId() == id);
	}
	
	public List<Filmes> buscarFilmesPorNome(final String filmes){
		return filmesList.stream()
				.filter(f -> f.getNome().equalsIgnoreCase(filmes))
				.collect(Collectors.toList());
	}
	public List<Filmes> buscarFilmesPorDiretor(final String diretor){
		return filmesList.stream()
				.filter(f -> f.getDiretor().equalsIgnoreCase(diretor))
				.collect(Collectors.toList());
	}
	 public List<Filmes> findAll(){
		 return filmesList;
	 }
	 
	 public Filmes buscaPorId(Integer id) {
		 return filmesList.stream().filter(f-> f.getId().equals(id))
				 .findFirst()
				 .orElse(null);
	 }
	 
	 public void update(Filmes filmes) {
		 filmesList.stream()
		 			.filter(f -> f.getId().equals(filmes.getId()))
		 			.forEach(f -> f.setNome(filmes.getNome()));
		 
		 filmesList.stream()
			.filter(f -> f.getId().equals(filmes.getId()))
			.forEach(f -> f.setDiretor(filmes.getDiretor()));
		 
		 filmesList.stream()
			.filter(f -> f.getId().equals(filmes.getId()))
			.forEach(f -> f.setAno(filmes.getAno()));
		 
		 filmesList.stream()
			.filter(f -> f.getId().equals(filmes.getId()))
			.forEach(f -> f.setNota(filmes.getNota()));
	 }
	

}
