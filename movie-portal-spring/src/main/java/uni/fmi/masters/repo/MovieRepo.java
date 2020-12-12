package uni.fmi.masters.repo;

import uni.fmi.masters.bean.MovieBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends JpaRepository<MovieBean, Integer>{

	
}
