package uni.fmi.masters.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uni.fmi.masters.bean.ActorBean;

@Repository
public interface ActorRepo extends JpaRepository<ActorBean, Integer> {

}
