package projetspring.sport.service;

import java.util.List;

import org.springframework.data.domain.Page;

import projetspring.sport.model.course;
import projetspring.sport.model.subscriber;

public interface courseServiceInterface {
    List<course> getAllCourse();
    void saveCourse(course course);
    course getCourseById(long id);
    void deleteCourseById(long id);
    Page<course> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
