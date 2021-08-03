package com.example.apiPharmacy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugsRepository extends JpaRepository<Drug, Long> {

    Drug findByDrugId(Long drugId);

}
