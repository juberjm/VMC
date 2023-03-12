package com.app.service;

import com.app.model.Disease;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DiseaseService {
    Disease addDisease(String diseaseName,
                       String description);
    List<Disease> getAllDiseases();
}
