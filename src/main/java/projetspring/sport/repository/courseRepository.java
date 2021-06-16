package projetspring.sport.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projetspring.sport.model.course;

@Repository
public interface courseRepository extends JpaRepository<course, Long>{
}


