package com.example.apiPharmacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DrugsRepository extends JpaRepository<Drug, Long> {

    Drug findByDrugId(Long drugId);

    List<Drug> findAllByDrugName(String drugName);

    Drug findByDrugName(String drugName);

}
