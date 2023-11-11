package com.crud.Service;



import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.crud.Entity.Movie;

import com.crud.ExceptionMessages.UserNotFound;
import com.crud.Repository.Movie_Repository;
import com.crud.otherclasses.Movie_Rating;
import com.crud.otherclasses.Rating;

@Service
public class Movie_Service {

	@Autowired
	private Movie_Repository repo;
	
	@Autowired
	private RestTemplate rs;
	String url="http://localhost:8082/rating/";
	
	public Movie create(Movie movie) {
		
		if(movie!=null) {
			return repo.save(movie);
		}
		else {
			throw new RuntimeException("Invalid Movie");
		}
	}
	public Movie read(String name) throws UserNotFound {
		System.out.println(repo.findByName(name));
     	  Movie mv=repo.findByName(name);
     	  if(mv==null) {
     		  throw new UserNotFound("Movie Not Found");
     	  }
     	return mv;
		
	}
	
	public void update(Long id,Movie mv) throws UserNotFound {
		
		if(repo.existsById(id)) {
			Movie mv1=repo.getReferenceById(id);
			mv1.setName(mv.getName());
			//System.out.println(mv.getName());
			mv1.setDirector(mv.getDirector());
			mv1.setActors(mv.getActors());
			repo.save(mv1);
		}
		else {
			throw new UserNotFound("Invalid id");
		}
	}
	public void delete(Long id) throws UserNotFound {
		if(repo.existsById(id)) {
			repo.deleteById(id);
		}
		else {
			throw new UserNotFound("Invalid id");
		}
	}
	
	public List<Object> getMovieDetails(String name){
		Movie mv=repo.findByName(name);
		
		List<Object> lo =new ArrayList<>();
		try {
		Rating rate=rs.getForObject(url+name,Rating.class);
		
		System.out.println(rate.getName());
		
		if(mv.getName().equals(rate.getName()))
		{
			lo=Arrays.asList(mv,rate);			
		}
		}
		catch(Exception e) {
			lo=Arrays.asList("Movie Rating Not Given For This Movie :"+name);
			
		}
		return  lo;
		
	}
	
}
