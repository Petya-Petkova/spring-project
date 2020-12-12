package uni.fmi.masters.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uni.fmi.masters.bean.ActorBean;
import uni.fmi.masters.bean.MovieBean;
import uni.fmi.masters.repo.ActorRepo;
import uni.fmi.masters.repo.MovieRepo;

@RestController
public class MovieController {

	private MovieRepo movieRepo;
	private ActorRepo actorRepo;
	
	public MovieController(MovieRepo movieRepo, ActorRepo actorRepo) {
		this.movieRepo=movieRepo;
		this.actorRepo=actorRepo;
	}
	
	
	@PostMapping(path = "/movie/add")
	public String addResult(
			@RequestParam(value = "title")String title,
			@RequestParam(value = "plot")String plot,
			@RequestParam(value = "rating")Double rating,
			@RequestParam(value = "release_date")String releaseDate,
			@RequestParam(value = "genre")String genre,
			@RequestParam(value = "poster")String poster,
			@RequestParam(value = "name")String name
			) {
	
			MovieBean movie = new MovieBean();
			ActorBean actorBean = new ActorBean();
			movie.setTitle(title);
			movie.setPlot(plot);
			movie.setRating(rating);
			movie.setReleaseDate(releaseDate);
			movie.setGenre(genre);
			movie.setPoster(poster);
			actorBean.setName(name);
			
			actorRepo.saveAndFlush(actorBean);
			movie.setActors(actorBean);
			movie = movieRepo.saveAndFlush(movie);
			
			if(movie != null) {
				return String.valueOf(movie.getId());
			}
			
			return "Error: insert unsuccessfull";
		}	
	
	@DeleteMapping(path = "/movie/delete")
	public ResponseEntity<Boolean> deleteMovie(
			@RequestParam(value = "id")int id
			){
		Optional <MovieBean> optionalComment = movieRepo.findById(id);
		Optional <ActorBean> optionalComment1 = actorRepo.findById(id);
		
		if(optionalComment.isPresent()) {
			MovieBean movieBean = optionalComment.get();
			ActorBean actor = optionalComment1.get();
			
			movieRepo.delete(movieBean);
			actorRepo.delete(actor);
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(path = "/movie/all")
	public List<MovieBean> getAllMovies(){
		return movieRepo.findAll();
	}
	
}
