package com.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "vaccination")
public class Vaccination {

    @Id
    @GeneratedValue

    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String vaccineName;

   // @Column(name = "diseases", nullable = false)

//    @ManyToMany(mappedBy = "vaccination", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
//    @JsonIgnoreProperties({"vaccination"})
//    private List<Disease> diseases;
    @OneToMany(mappedBy = "vaccination", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JsonIgnoreProperties({"vaccination"})
    private List<Disease> diseases;

    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @Column(name = "numberOfShots", nullable = false)
    private int numberOfShots;

    @Column(name = "shotInternalVal")
    private int shotInternalVal;

    @Column(name = "duration", nullable = false)
    private int duration;
    
//    @ManyToMany(mappedBy = "vaccinations", fetch = FetchType.EAGER) // FIXXXXXXXXXXXXXXXXXXXXXXXXXXX
//    private List<Clinic> clinics; //


//    public Vaccination(String vaccineName, List<Disease> diseases, String manufacturer, int numberOfShots, int shotInternalVal, int duration) {
//        this.vaccineName = vaccineName;
//        this.diseases = diseases;
//        this.manufacturer = manufacturer;
//        this.numberOfShots = numberOfShots;
//        this.shotInternalVal = shotInternalVal;
//        this.duration = duration;
    
    						//CODE ADDED BY FARAZ 11-03-2023 
    @Fetch(FetchMode.SELECT)
    @ManyToMany(mappedBy = "vaccinations", fetch = FetchType.EAGER)
    private List<Appointment> appointments;

    @Fetch(FetchMode.SELECT)
    @ManyToMany(mappedBy = "vaccinations", fetch = FetchType.EAGER)
    private List<Clinic> clinics;
    						//CODE ADDED BY FARAZ 11-03-2023 
    
//    }
    public Vaccination(String vaccineName, List<Disease> diseases, String manufacturer, int numberOfShots, int shotInternalVal, int duration) {
        this.vaccineName = vaccineName;
        this.diseases = diseases;
        this.manufacturer = manufacturer;
        this.numberOfShots = numberOfShots;
        this.shotInternalVal = shotInternalVal;
        this.duration = duration;
    }
    

    public Vaccination() {

    }

    

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
//    public long getVaccinationId() {
//        return vaccinationId;
//    }
//
//    public void setVaccinationId(long vaccinationId) {
//        this.vaccinationId = vaccinationId;
//    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getNumberOfShots() {
        return numberOfShots;
    }

    public void setNumberOfShots(int numberOfShots) {
        this.numberOfShots = numberOfShots;
    }

    public int getShotInternalVal() {
        return shotInternalVal;
    }

    public void setShotInternalVal(int shotInternalVal) {
        this.shotInternalVal = shotInternalVal;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
