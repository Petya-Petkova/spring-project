package uni.fmi.masters.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="series")
public class SeriesBean {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "rating")
    private double rating;
    
    @Column(name = "release_date")
    private String release_date;
    
    @Column(name = "plot")
    private String plot;
    
    @Column(name = "genre")
    private String genre;
    
    @Column(name = "poster")
    private String poster;

    @OneToOne
    private ActorBean actors;
    public SeriesBean() {
    }

    public SeriesBean(String title, String plot, double rating, String releaseDate, String genre, String poster) {
        this.title = title;
        this.plot = plot;
        this.rating = rating;
        this.release_date = releaseDate;
        this.genre = genre;
        this.poster = poster;
    }

    
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getReleaseDate() {
		return release_date;
	}

	public void setReleaseDate(String releaseDate) {
		this.release_date = releaseDate;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public ActorBean getActors() {
    	return actors;
    }

    public void setActors(ActorBean actors) {
    	this.actors = actors;
    }
    @Override
    public String toString() {
        return  id + "," + title +   ", " + plot + ", " + rating +
                "," + release_date + ", " + genre + ", " + poster +  ", " + actors;
    }
}
