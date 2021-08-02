package com.example.apiPharmacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserDrugsController {

    @Autowired
    DrugsService drugsService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<Drug> drugsNames = drugsService.gerAllDrugs();

        //TODO: get the user id
//        model.addAttribute("user",userRepository.findUsersUserName("aseel"));
        model.addAttribute("userId", 4L);
        model.addAttribute("drugsNames", drugsNames);
        return "UserDrugs";
    }

    @PostMapping("/addDrug")
    public void addDrug(@RequestParam Long userId, @RequestParam Long drugId) {
        if (drugId != 0) {
            assignDrugToUser(userId, drugId);
        }

        //TODO: redirect and handle the exception
    }

//////>>>>>> TODO: put the following function in user service

    /**
     * function to assign specific drug to specific user
     *
     * @param userId
     * @param drugId
     */
    public void assignDrugToUser(Long userId, Long drugId) {
        Users user = userRepository.findUsersByUserId(userId);
        Drug drug = drugsService.getDrug(drugId);
        user.getDrugs().add(drug);
        userRepository.save(user);
    }

    ////////////////////////////////////////////////////////////
//    @RequestMapping(value = "/autocomplete")
//    @ResponseBody
//    public List<String> autoName(@RequestParam(value = "term", required = false, defaultValue = "")String term){
//        List<String> designation = dao.getDesignation(term);
//        return designation;
//    }


    //////////////////////////////////////////////////////////

}
