package com.chints.springboot.experiment;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;

import com.chints.springboot.experiment.entities.Series;
import com.chints.springboot.experiment.repository.SeriesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

class Greeting {

	private final long id;
	private final String content;

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}

@RestController
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private SeriesRepository seriesRepository;
	
	@RequestMapping("/")
	public String index() {
		return "landing page!chints417";
	}
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@PostMapping("/addSeries")
	public Iterable<Series> addSeries(@RequestParam String name,@RequestParam Integer numOfEpisodes) {
		Series series = new Series();
		series.setName(name);
		series.setNumOfEpisodes(numOfEpisodes);
		seriesRepository.save(series);
		
		
		return seriesRepository.findAll();
	}
	@PutMapping("/updateSeriesNoOfEpisodes")
	public Series updateSeriesNoOfEpisodes(@RequestParam Integer numOfEpisodes,@RequestParam String name) {
		Series series=seriesRepository.findByName(name);
		series.setNumOfEpisodes(numOfEpisodes);
		
		seriesRepository.save(series);
		
		return seriesRepository.findByName(name);
	}
	
	@DeleteMapping("deleteSeries")
	public Iterable<Series> deleteSeries(@RequestParam Integer id){
		seriesRepository.deleteById(id);
		
		return seriesRepository.findAll();
	}

}