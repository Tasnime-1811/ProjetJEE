package projetspring.sport.service;

import java.util.List;

import org.springframework.data.domain.Page;

import projetspring.sport.model.coach;

public interface coachServiceInterface {
    List<coach> getAllCoach();
    void saveCoach(coach coach);
    coach getCoachById(long id);
    void deleteCoachById(long id);
    Page<coach> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
