package projetspring.sport.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;
import projetspring.sport.model.course;
import projetspring.sport.repository.courseRepository;

@Service
public class courseService implements courseServiceInterface {

    @Autowired
    private courseRepository courseRepository;

    @Override
    public List<course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public void saveCourse(course course) {
        this.courseRepository.save(course);
    }

    @Override
    public course getCourseById(long id) {
        Optional<course> optional = courseRepository.findById(id);
        course course = null;
        if (optional.isPresent()) {
            course = optional.get();
        } else {
            throw new RuntimeException("Course not found for id :: " + id);
        }
        return course;
    }

    @Override
    public void deleteCourseById(long id) {
        this.courseRepository.deleteById(id);
    }

    @Override
    public Page<course> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.courseRepository.findAll(pageable);
    }
}
