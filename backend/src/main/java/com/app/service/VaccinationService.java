package com.app.service;

import com.app.model.Disease;
import com.app.model.Vaccination;

import java.util.List;

public interface VaccinationService {
    Vaccination createVaccination(String vaccineName, List<String> diseasesList, String manufacturer,
                                  int numberOfShots,
                                  int shotInternalVal,
                                  int duration);
    List<Vaccination> getAllVaccines();
}
