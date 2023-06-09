package com.app.service.impl;

import com.app.model.Clinic;
import com.app.model.Disease;
import com.app.repository.ClinicRepository;
import com.app.repository.DiseaseRepository;
import com.app.service.DiseaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiseaseServiceImpl implements DiseaseService {
    @Autowired
    DiseaseRepository diseaseRepository;

    @Override
    public Disease addDisease(String diseaseName, String description) {
        Disease disease = new Disease(diseaseName, description);
        return this.diseaseRepository.save(disease);
    }
    @Override
    public List<Disease> getAllDiseases(){
        List<Disease> allDiseases = this.diseaseRepository.findAll();
        List<String> diseaseList = new ArrayList<String>();
        for (Disease n : allDiseases){
//            JSONObject entity = new JSONObject();
//            entity.put("diseaseId",n.getId());
           // entity.put("diseaseName",n.getDiseaseName());
            diseaseList.add(n.getDiseaseName());
        }
        return allDiseases;
        //return ResponseEntity.ok(diseaseList);
    }
}
