package com.crud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.Entity.Rating;
import com.crud.ExceptionMessages.UserNotFound;
import com.crud.Repository.Rating_Repositoey;

import jakarta.transaction.Transactional;

@Service
public class Rating_serive {

	@Autowired
	Rating_Repositoey ratingRepository;

	    public Rating updateAverage(String name, double stars){

	        Rating rating = ratingRepository.findByName(name);

	        if(rating == null){
	            rating = new Rating();
	            rating.setName(name);
	            rating.setAvgRating(stars);
	            rating.setNo_of_people_rated(1);
	        } 
	        else {
	            int count = rating.getNo_of_people_rated();
	            double newAverage = (rating.getAvgRating() * count + stars) / (count + 1);

	            rating.setAvgRating(newAverage);
	            rating.setNo_of_people_rated(++count);
	        }

	        return ratingRepository.save(rating);
	    }
	    public Rating fetchRating(String name) throws UserNotFound {
	    	Rating rating=ratingRepository.findByName(name);
	    	
	    	if(rating==null) {
	    		throw new UserNotFound("Movie not Found :"+name);
	    	}
	    	return rating;
	    }
	    @Transactional
	    public int delete(String name) {
	    	int del=ratingRepository.deleteByName(name);
			return del;
	    }

}
