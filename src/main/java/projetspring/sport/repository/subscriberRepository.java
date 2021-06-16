package projetspring.sport.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projetspring.sport.model.subscriber;

@Repository
public interface subscriberRepository extends JpaRepository<subscriber, Long> {
}
