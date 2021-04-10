package projetspring.sport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projetspring.sport.model.coach;

@Repository
public interface coachRepository extends JpaRepository<coach, Long>{
}
