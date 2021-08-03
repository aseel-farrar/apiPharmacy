package com.example.apiPharmacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    DrugsService drugsService;

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

}
