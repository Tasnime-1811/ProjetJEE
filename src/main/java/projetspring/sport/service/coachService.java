package projetspring.sport.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;
import projetspring.sport.model.coach;
import projetspring.sport.repository.coachRepository;

@Service
public class coachService implements coachServiceInterface {

    @Autowired
    private coachRepository coachRepository;

    @Override
    public List<coach> getAllCoach() {
        return coachRepository.findAll();
    }

    @Override
    public void saveCoach(coach coach) {
        this.coachRepository.save(coach);
    }

    @Override
    public coach getCoachById(long id) {
        Optional<coach> optional = coachRepository.findById(id);
        coach coach = null;
        if (optional.isPresent()) {
            coach = optional.get();
        } else {
            throw new RuntimeException("Coach not found for id :: " + id);
        }
        return coach;
    }

    @Override
    public void deleteCoachById(long id) {
        this.coachRepository.deleteById(id);
    }

    @Override
    public Page<coach> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.coachRepository.findAll(pageable);
    }
}
