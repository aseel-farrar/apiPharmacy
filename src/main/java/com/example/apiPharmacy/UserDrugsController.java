package com.example.apiPharmacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class UserDrugsController {

    @Autowired
    DrugsService drugsService;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String home(Model model) {
        List<Drug> drugs = drugsService.gerAllDrugs();

        //TODO: get the user id and add it to the model instead static value
        model.addAttribute("userId", 4L);
        model.addAttribute("drugs", drugs);
        return "UserDrugs";
    }

    @PostMapping("/addDrug")
    public RedirectView addDrug(@RequestParam Long userId, @RequestParam Long drugId) {
        if (drugId != 0) {
            userService.assignDrugToUser(userId, drugId);
        }

        //TODO: redirect
        return new RedirectView("#");
    }

}
