package com.chints.springboot.experiment.entities;

import javax.persistence.*;

@Entity
public class Series {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	
	private String name;
	private Integer numOfEpisodes;
	
	public Series() {
		
	}
	
	public Series(Integer id, String name, Integer numOfEpisodes) {
		super();
		this.id = id;
		this.name = name;
		this.numOfEpisodes = numOfEpisodes;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumOfEpisodes() {
		return numOfEpisodes;
	}
	public void setNumOfEpisodes(Integer numOfEpisodes) {
		this.numOfEpisodes = numOfEpisodes;
	}
	
}
