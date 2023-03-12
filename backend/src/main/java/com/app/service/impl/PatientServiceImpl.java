package com.app.service.impl;

import com.app.exception.ResourceNotFoundException;
import com.app.model.Appointment;
import com.app.model.User;
import com.app.repository.AppointmentRepository;
import com.app.repository.PatientRepository;
import com.app.repository.UserRepository;
import com.app.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Override
    public List<Appointment> getVaccinationHistory(long id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
        return user.getAppointmentList();
    }

//    @Override
//    public Appointment checkInAppointment(long id) {
//        Appointment appointment = this.appointmentRepository.findById(id).orElse(null);
//        if(appointment != null){
//            appointment.setStatus("CheckedIn");
//        }
//        return this.appointmentRepository.save(appointment);
//    }
}
