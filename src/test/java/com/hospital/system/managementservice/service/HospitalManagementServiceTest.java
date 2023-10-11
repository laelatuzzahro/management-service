package com.hospital.system.managementservice.service;

import com.hospital.system.managementservice.dto.GetDataRequestPagination;
import com.hospital.system.managementservice.dto.SaveRequest;
import com.hospital.system.managementservice.model.Doctor;
import com.hospital.system.managementservice.model.HistoryVisit;
import com.hospital.system.managementservice.model.Patient;
import com.hospital.system.managementservice.repository.DoctorRepository;
import com.hospital.system.managementservice.repository.HistoryVisitRepository;
import com.hospital.system.managementservice.repository.PatientRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = HospitalManagementService.class)
public class HospitalManagementServiceTest {

    @Autowired
    private HospitalManagementService service;

    @MockBean
    private DoctorRepository doctorRepository;

    @MockBean
    private PatientRepository patientRepository;

    @MockBean
    private HistoryVisitRepository historyVisitRepository;

    @Test
    public void saveDataDoctor() {
        when(doctorRepository.saveAndFlush(any())).thenReturn(Doctor.builder().build());

        var response = service.saveData(SaveRequest.builder()
                .doctor(Doctor.builder().build()).build());
        Assertions.assertEquals(true, response.getIsSuccess());
    }

    @Test
    public void saveDataPatient() {
        when(patientRepository.saveAndFlush(any())).thenReturn(Patient.builder().build());
        var response = service.saveData(SaveRequest.builder()
                .patient(Patient.builder().build()).build());
        Assertions.assertEquals(true, response.getIsSuccess());
    }

    @Test
    public void saveDataHistoryVisit() {
        when(historyVisitRepository.saveAndFlush(any())).thenReturn(HistoryVisit.builder().build());
        var response = service.saveData(SaveRequest.builder()
                .historyVisit(HistoryVisit.builder().build()).build());
        Assertions.assertEquals(true, response.getIsSuccess());
    }

    @Test
    public void getListPatient() {
        Page<Patient> pagePatient = new PageImpl<>(List.of(Patient.builder().build()), PageRequest.of(1,1),1l);
        when(patientRepository.findAll(PageRequest.of(1, 1))).thenReturn(pagePatient);
        var response = service.getListPatient(GetDataRequestPagination.builder()
                .direction("asc")
                .pageNumber(1)
                .pageSize(1)
                .sortBy("name").build());
        Assertions.assertNotNull(response);
    }
}
