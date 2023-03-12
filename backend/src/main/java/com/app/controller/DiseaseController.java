package com.app.controller;

import com.app.model.Disease;
import com.app.model.Vaccination;
import com.app.payload.AddDiseaseRequest;
import com.app.security.CurrentUser;

import com.app.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diseases")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    @GetMapping("/allDiseases")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Disease> getAllDiseases() {
        return this.diseaseService.getAllDiseases();
    }

    @PostMapping("/addDisease")
    @PreAuthorize("hasRole('ADMIN')")
    public Disease addDisease(@CurrentUser @RequestBody AddDiseaseRequest request) {
        return this.diseaseService.addDisease(request.getDiseaseName(), request.getDescription());
    }
}
