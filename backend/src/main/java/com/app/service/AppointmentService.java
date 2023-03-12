package com.app.service;

import com.nimbusds.jose.shaded.json.JSONObject;
import com.app.model.Appointment;
import com.app.model.Clinic;
import com.app.model.Vaccination;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AppointmentService {

    Appointment makeAppointment(long patientId, String appointmentTime, String currentTime, List<Long> vaccinationIds,
                                long clinicId);

    Appointment getAppointment(long id);

    List<Clinic> getAllClinics();

    List<Vaccination>  getAllDueVaccines();

    Appointment cancelAppointment(long id);

    Appointment checkinAppointment(long id);

    Appointment updateAppointment(long appointmentId, String appointmentTime, String currentTime, long clinicId);

    List<Appointment> allCheckin(long patientId, String currentTime);

    List<Appointment> allAppointments(long patientId);

    List<Appointment> getAllAppointmentsByClinic(String clinicId);

}
