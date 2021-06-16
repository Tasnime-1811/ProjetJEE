package projetspring.sport.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projetspring.sport.model.course;
import projetspring.sport.service.courseService;

import java.util.List;

@Controller
public class courseController {

    @Autowired
    private courseService courseService;

    @GetMapping("/CourseManagment")
    public String viewHomePage(Model model) {
        return findPaginateddd(1, "name", "asc", model);
    }

    @GetMapping("/CourseManagment/NewCourseForm")
    public String showNewCourseForm(Model model) {
        course course = new course();
        model.addAttribute("course", course);
        return "new_Course";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(course course ,Model model) {
        courseService.saveCourse(course);
        return findPaginateddd(1, "name", "asc", model);
    }

    @GetMapping("/CourseManagment/UpdateCourse/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
        course course = courseService.getCourseById(id);
        model.addAttribute("course", course);
        return "update_Course";
    }

    @GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable (value = "id") long id, Model model) {

        this.courseService.deleteCourseById(id);
        return findPaginateddd(1, "name", "asc", model);}

    @GetMapping("/page3/{pageNo}")
    public String findPaginateddd(@PathVariable (value = "pageNo") int pageNo,
                                  @RequestParam("sortField") String sortField,
                                  @RequestParam("sortDir") String sortDir,
                                  Model model) {
        int pageSize = 10;

        Page<course> page = courseService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<course> listCourse = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listCourse", listCourse);
        return "indexCourse"+
                "";
    }
    }



