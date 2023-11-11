package com.crud.Entity;



import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	private String director;
	
	@ElementCollection
	private List<String> actors;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDirector() {
		return director;
	}



	public void setDirector(String director) {
		this.director = director;
	}



	public List<String> getActors() {
		return actors;
	}



	public void setActors(List<String> actors) {
		this.actors = actors;
	}



	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", director=" + director + ", actors=" + actors + "]";
	}

}
