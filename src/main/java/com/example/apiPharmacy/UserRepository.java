package com.example.apiPharmacy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
//////>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ADD IF NOT EXIST  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<</////
    Users findUsersByUserId(Long id);
//////>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ADD IF NOT EXIST  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<</////
}
