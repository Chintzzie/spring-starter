package com.chints.springboot.experiment.repository;

import org.springframework.data.repository.CrudRepository;

import com.chints.springboot.experiment.entities.Series;

public interface SeriesRepository extends CrudRepository<Series, Integer> {
	
	public Series findByName(String name);
}
