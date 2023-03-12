package com.app.service;

import com.app.model.Appointment;

import java.util.List;

public interface PatientService {
    List<Appointment> getVaccinationHistory(long id);
//    Appointment checkInAppointment(long id);
}
