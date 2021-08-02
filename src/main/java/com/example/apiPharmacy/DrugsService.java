package com.example.apiPharmacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class DrugsService {
    @Autowired
    DrugsRepository drugsRepository;

//    @Autowired
//    UserDrugsRepository userDrugsRepository;

    public void addDrug(Drug drug) {
        drugsRepository.save(drug);
    }


    public void addAllDrugs(List<Drug> drugs) {
        drugsRepository.saveAll(drugs);
    }

    public Drug getDrug(String drugName) {
        return drugsRepository.findByDrugName(drugName);
    }

    public Drug getDrug(Long id) {
        return drugsRepository.findByDrugId(id);
    }

    public List<Drug> gerAllDrugs() {
        return drugsRepository.findAll();
    }


    @Transactional
    public List<String> getDrugStrings(String term) {
        List<Drug> drugs = gerAllDrugs();
        List<String> stringDrugs=new ArrayList<>();
        for (Drug drug: drugs) {
            stringDrugs.add(drug.getDrugName());
        }
        return stringDrugs;
    }
}
