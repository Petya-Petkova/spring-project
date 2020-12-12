package uni.fmi.masters.repo;

import uni.fmi.masters.bean.SeriesBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepo extends JpaRepository<SeriesBean, Integer> {

}
