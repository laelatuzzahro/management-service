package com.hospital.system.managementservice.repository;

import com.hospital.system.managementservice.dto.HistoryVisitResponse;
import com.hospital.system.managementservice.model.HistoryVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryVisitRepository extends JpaRepository<HistoryVisit, Long> {

    @Query(value = "select dc.name as doctorName, hv.visit_date as visitDate, hv.diagnosis as diagnosis from history_visit as hv join doctor as dc on hv.id_doctor = dc.id where hv.id_patient = :idPatient", nativeQuery = true)
    List<HistoryVisitResponse> findByIdPatient(@Param("idPatient") Long idPatient);
}
