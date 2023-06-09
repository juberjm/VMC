package com.app.repository;

import com.app.model.Slot;
import com.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {

    @Query("SELECT s.id FROM Slot s WHERE s.clinic.id = ?1")
    List<Long> findByClinicId(Long clinicId);

}


