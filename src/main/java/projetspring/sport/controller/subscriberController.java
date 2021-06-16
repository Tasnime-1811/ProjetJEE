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
import projetspring.sport.model.subscriber;
import projetspring.sport.service.subscriberService;

@Controller
public class subscriberController {

    @Autowired
    private subscriberService subscriberService;

    @GetMapping("/SubscriberManagment")
    public String viewHomePage(Model model) {
        return findPaginateddd(1, "firstName", "asc", model);
    }

    @GetMapping("/SubscriberManagment/NewSubscriberForm")
    public String showNewSubscriberForm(Model model) {
        subscriber subscriber = new subscriber();
        model.addAttribute("subscriber", subscriber);
        return "new_Subscriber";
    }

    @PostMapping("/saveSubscriber")
    public String saveCoach(subscriber subscriber ,Model model) {
        subscriberService.saveSubscriber(subscriber);
        return findPaginateddd(1, "firstName", "asc", model);
    }

    @GetMapping("/SubscriberManagment/UpdateSubscriber/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {


        subscriber subscriber = subscriberService.getSubscriberById(id);
        model.addAttribute("subscriber", subscriber);
        return "update_Subscriber";
    }

    @GetMapping("/deleteSubscriber/{id}")
    public String deleteSubscriber(@PathVariable (value = "id") long id, Model model) {

        this.subscriberService.deleteSubscriberById(id);
        return findPaginateddd(1, "firstName", "asc", model);
    }


    @GetMapping("/page2/{pageNo}")
    public String findPaginateddd(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 10;

        Page<subscriber> page = subscriberService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<subscriber> listSubscriber = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listSubscriber", listSubscriber);
        return "indexSubscriber"+
                "";
    }
}

