package com.crud.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.Entity.Rating;
@Repository
public interface Rating_Repositoey extends JpaRepository<Rating, Long> {

	Rating findByName(String name);

    List<Rating> findAllByAvgRatingBetween(double min,double max);
    
    public int deleteByName(String name);
}
