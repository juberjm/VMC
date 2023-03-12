package com.app.service.impl;

import com.app.model.Disease;
import com.app.model.Vaccination;
import com.app.repository.DiseaseRepository;
import com.app.repository.VaccinationRepository;
import com.app.service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinationServiceImpl implements VaccinationService {
    @Autowired
    VaccinationRepository vaccinationRepository;
    @Autowired
    DiseaseRepository diseaseRepository;
    @Override
    public Vaccination createVaccination(String vaccineName, List<String> diseasesList, String manufacturer,
                                          int numberOfShots,
                                          int shotInternalVal,
                                          int duration) {
        List<Disease> diseases = new ArrayList<>();
        for(int i = 0; i < diseasesList.size(); i++) {
            Disease disease = diseaseRepository.findByDiseaseName(diseasesList.get(i)).get();
            diseases.add(disease);
        }
        if(duration == 0) {
            duration = Integer.MAX_VALUE;
        }
//        Vaccination vaccination = new Vaccination(duration, vaccineName, diseases ,manufacturer, numberOfShots, shotInternalVal, null);
        Vaccination vaccination = new Vaccination(vaccineName, diseases ,manufacturer, numberOfShots, shotInternalVal, duration);
//        List<Vaccination> vaccinationList = new ArrayList<>();
//        vaccinationList.add(vaccination);
        for(Disease disease : diseases) {
            disease.setVaccination(vaccination);
        }
        vaccination.setDiseases(diseases);
        return this.vaccinationRepository.save(vaccination);
    }

    @Override
    public List<Vaccination> getAllVaccines(){
        List<Vaccination> allVaccines = this.vaccinationRepository.findAll();
        return allVaccines;

    }
}
