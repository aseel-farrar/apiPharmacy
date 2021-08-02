package com.example.apiPharmacy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findUsersByUserId(Long id);
//    Users findUsersUserName(String name);
}
