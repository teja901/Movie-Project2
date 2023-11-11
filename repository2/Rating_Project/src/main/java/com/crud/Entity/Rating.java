package com.crud.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rating {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.SEQUENCE)
	   private Long id;
	   private String name;
	   private double avgRating;
	   private int no_of_people_rated;
	   
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
	public double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
	public int getNo_of_people_rated() {
		return no_of_people_rated;
	}
	public void setNo_of_people_rated(int no_of_people_rated) {
		this.no_of_people_rated = no_of_people_rated;
	}
	@Override
	public String toString() {
		return "Rating [id=" + id + ", name=" + name + ", avgRating=" + avgRating + ", no_of_people_rated="
				+ no_of_people_rated + "]";
	}
	   
	   
}
