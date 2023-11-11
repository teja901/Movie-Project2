package com.crud;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.crud.Entity.Movie;

@SpringBootTest(webEnvironment =SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Movie_Test {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate ts;
	
	
	@Test
	public void testSave() {
		
        Movie mv=new Movie();
        mv.setName("RRR");
        mv.setDirector("Rajamouli");
        
        Movie mv1=new Movie();
        mv1.setName("RRR");
        mv1.setDirector("Rajamouli");
        
        List<String> actors1=Arrays.asList("samantha","Teja");
		 mv1.setActors(actors1);
        
		List<String> actors=Arrays.asList("Ramcharan","Ntr");
		 mv.setActors(actors);
		
		ResponseEntity<Movie> rs=ts.postForEntity(
				"http://localhost:"+port+"/save",
				new HttpEntity<>(mv),Movie.class
				);
		assertEquals(HttpStatus.OK, rs.getStatusCode());
		System.out.println(rs.getBody());
		
		ResponseEntity<Movie> rs1=ts.postForEntity(
				"http://localhost:"+port+"/save",
				new HttpEntity<>(mv1),Movie.class
				);
		assertEquals(HttpStatus.OK, rs1.getStatusCode());
		System.out.println(rs1.getBody());
		System.out.println("save method");
		
	}
	
	@Test
	public void getMovieTest() {
		
		Long id=1l;
		ResponseEntity<Movie> rs=ts.getForEntity(
				"http://localhost:"+port+"/"
				+id,Movie.class
				);
	
		assertEquals(HttpStatus.OK, rs.getStatusCode());
		System.out.println(rs.getBody());
		System.out.println("get method");
	}
	
	@Test
	public void updateMovie() {
		long id=1l;
		
		Movie mve=new Movie();
		List<String>actors= Arrays.asList("nithin","samantha","prabhas");
		
		mve.setActors(actors);
		mve.setDirector("rajamouli");
		mve.setName("RRR");
		
		ResponseEntity<Movie> rs=ts.exchange("http://localhost:"+port+"/"+id,
				HttpMethod.PUT, new HttpEntity<>(mve), Movie.class);
				
		assertEquals(HttpStatus.OK, rs.getStatusCode());
		
	
	}
	public void deleteMovie() {
		long id=1l;
		
		
		ResponseEntity<Movie> rs=ts.exchange("http://localhost:"+port+"/"+id,
				HttpMethod.DELETE,null, Movie.class);
				
		assertEquals(HttpStatus.OK, rs.getStatusCode());
		
	
	}
	
}
