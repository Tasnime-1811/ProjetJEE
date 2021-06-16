package projetspring.sport.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projetspring.sport.model.coach;
import projetspring.sport.service.coachService;

@Controller
public class coachController {

    @Autowired
    private coachService coachService;

    // display list of Coachs
    @GetMapping("/CoachManagment")
    public String viewHomePage(Model model) {
        return findPaginated(1, "firstName", "asc", model);
    }

    @GetMapping("/CoachManagment/NewCoachForm")
    public String showNewCoachForm(Model model) {
        coach coach = new coach();
        model.addAttribute("coach", coach);
        return "new_Coach";
    }

    @PostMapping("/saveCoach")
    public String saveCoach(coach coach ,Model model) {
        coachService.saveCoach(coach);
        return findPaginated(1, "firstName", "asc", model);
    }

    @GetMapping("/CoachManagment/UpdateCoach/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) {
        coach coach = coachService.getCoachById(id);
        model.addAttribute("coach", coach);
        return "update_Coach";
    }

    @GetMapping("/deleteCoach/{id}")
    public String deleteCoach(@PathVariable (value = "id") long id, Model model) {
        this.coachService.deleteCoachById(id);
        return findPaginated(1, "firstName", "asc", model);
    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page <coach> page = coachService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<coach> listCoach = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listCoach", listCoach);
        return "indexCoach"+
                "";
    }
}

