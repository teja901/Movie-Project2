package com.crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Entity.Movie;
import com.crud.ExceptionMessages.UserNotFound;
import com.crud.Service.Movie_Service;
import com.crud.otherclasses.Movie_Rating;

@RestController
@RequestMapping("/movie")
public class Movie_Controller {
	
	@Autowired
	private Movie_Service ms;
	
	@PostMapping("/save")
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
		
		Movie mv=ms.create(movie);
		
		return ResponseEntity.ok(mv);
	}
	

	@PutMapping("/{id}")
	public  ResponseEntity<Movie> updateMovie(@PathVariable Long id,@RequestBody Movie mv) throws UserNotFound {
		ms.update(id,mv);	
		return ResponseEntity.ok(mv);	
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Movie> deleteMovie(@PathVariable Long id) throws UserNotFound {
		ms.delete(id);
		Movie mv=new Movie();
		return ResponseEntity.ok(mv);	
	}
	
	@GetMapping("/moviedetails/{name}")
	public List<Object> getMovieplusRating(@PathVariable String name){
		return ms.getMovieDetails(name);
	}
	
	@GetMapping("/move/{name}")
	public Movie getMovie(@PathVariable String name) throws UserNotFound{
		Movie ls= ms.read(name);
		return ls;	
		
	}
	
}
