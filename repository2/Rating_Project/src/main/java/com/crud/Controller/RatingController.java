package com.crud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Entity.Rating;
import com.crud.Entity.RatingRequest;
import com.crud.ExceptionMessages.UserNotFound;
import com.crud.Service.Rating_serive;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	Rating_serive ratingService;


    @GetMapping("/{name}")
    public ResponseEntity<Rating> getRating(@PathVariable String name) throws UserNotFound{
        Rating rating = ratingService.fetchRating(name);
        return ResponseEntity.ok(rating);
    }

    @PostMapping("/save")
    public ResponseEntity<Rating> updateRating(@RequestBody RatingRequest request){
    	Rating rating =ratingService.updateAverage(request.getName(),request.getStars());
		return ResponseEntity.ok(rating);
    	
    }
    
    @DeleteMapping("/{name}")
    public String deleteMovie(@PathVariable String name) throws UserNotFound {
    	
    	int del=ratingService.delete(name);
    	if(del<=0) {
    		throw new UserNotFound("Movies not found.."+name);
    	}
    	return "Movie deleted successfully"+name;
    }

}
