package com.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.Entity.Movie;

@Repository
public interface Movie_Repository  extends JpaRepository<Movie, Long>{

	
	public Movie findByName(String name);
}
