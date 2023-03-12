package com.app.service;

import com.app.model.Address;
import com.app.model.Clinic;

import com.app.model.Vaccination;
import com.app.payload.SignUpRequest;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ClinicService {
    List<Vaccination> getVaccinations(long id);
    Clinic createClinic(String clinicName,
                       String streetAndNumber,
                        String city,
                        String state,
                        int zipCode,
                        String businessHours,
                        int NumberOfPhysicians);
    Clinic addVaccinations(long clinic_id, List<Long> vaccination_ids);

}
