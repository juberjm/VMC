package com.app.controller;


import com.app.model.Disease;
import com.app.model.Vaccination;
import com.app.payload.AddDiseaseRequest;
import com.app.payload.AddVaccinationRequest;
import com.app.security.CurrentUser;
import com.app.service.DiseaseService;
import com.app.service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vaccination")
public class VaccinationController {

    @Autowired private VaccinationService vaccinationService;

    @GetMapping("/allVaccines")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Vaccination> getAllVaccines() {
        return this.vaccinationService.getAllVaccines();
    }


    @PostMapping("/createVaccination")
    @PreAuthorize("hasRole('ADMIN')")
    public Vaccination createVaccination(@CurrentUser @RequestBody AddVaccinationRequest request
    ) {
        return this.vaccinationService.createVaccination(request.getVaccineName(),request.getDiseasesList(), request.getManufacturer(), request.getNumberOfShots(), request.getShotInternalVal(), request.getDuration());
    }

}
