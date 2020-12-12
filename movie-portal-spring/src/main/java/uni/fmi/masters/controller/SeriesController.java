package uni.fmi.masters.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uni.fmi.masters.bean.ActorBean;
import uni.fmi.masters.bean.MovieBean;
import uni.fmi.masters.bean.SeriesBean;
import uni.fmi.masters.repo.ActorRepo;
import uni.fmi.masters.repo.SeriesRepo;

@RestController
public class SeriesController {
	
	private SeriesRepo seriesRepo;
	private ActorRepo actorRepo;

	public SeriesController(SeriesRepo seriesRepo, ActorRepo actorRepo) {
		this.seriesRepo = seriesRepo;
		this.actorRepo=actorRepo;
	}
	
	@PostMapping(path="/add/series")
	public String addResult(
			@RequestParam(value = "title")String title,
			@RequestParam(value = "plot")String plot,
			@RequestParam(value = "rating")Double rating,
			@RequestParam(value = "release_date")String releaseDate,
			@RequestParam(value = "genre")String genre,
			@RequestParam(value = "poster")String poster,
			@RequestParam(value = "name")String name
			) {
	
			SeriesBean series = new SeriesBean();
			ActorBean actorBean = new ActorBean();
			series.setTitle(title);
			series.setPlot(plot);
			series.setRating(rating);
			series.setReleaseDate(releaseDate);
			series.setGenre(genre);
			series.setPoster(poster);
			actorBean.setName(name);
			
			actorRepo.saveAndFlush(actorBean);
			series.setActors(actorBean);
			series = seriesRepo.saveAndFlush(series);
			
			if(series != null) {
				return String.valueOf(series.getId());
			}
			
			return "Error: insert unsuccessfull";
		}	
	
	@DeleteMapping(path = "/series/delete")
	public ResponseEntity<Boolean> deleteComment(
			@RequestParam(value = "id")int id
			){
		Optional<SeriesBean> optionalComment = seriesRepo.findById(id);
		Optional <ActorBean> optionalComment1 = actorRepo.findById(id);
		
		if(optionalComment.isPresent()) {
			SeriesBean seriesBean = optionalComment.get();
			ActorBean actor = optionalComment1.get();
			
			seriesRepo.delete(seriesBean);
			actorRepo.delete(actor);
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(path = "/series/all")
	public List<SeriesBean> getAllSeries(){
		return seriesRepo.findAll();
	}
}
