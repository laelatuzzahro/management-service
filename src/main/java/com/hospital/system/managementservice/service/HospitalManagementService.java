package com.hospital.system.managementservice.service;

import com.hospital.system.managementservice.dto.*;
import com.hospital.system.managementservice.model.Doctor;
import com.hospital.system.managementservice.model.Patient;
import com.hospital.system.managementservice.repository.DoctorRepository;
import com.hospital.system.managementservice.repository.HistoryVisitRepository;
import com.hospital.system.managementservice.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class HospitalManagementService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private HistoryVisitRepository historyVisitRepository;

    public PatientResponse getDetailPatientByNik(PatientRequest request) {
        List<HistoryVisitDto> visitDtoList = new ArrayList<>();
        var patientRes = patientRepository.findByNik(request.getNik());
        var historyVisitList = historyVisitRepository.findByIdPatient(patientRes.get().getId());
        historyVisitList.stream().forEach(historyVisit -> {
            visitDtoList.add(HistoryVisitDto.builder()
                    .doctorName(historyVisit.getDoctorName())
                    .dateVisit(historyVisit.getVisistDate())
                    .diagnosis(historyVisit.getDiagnosis()).build());
        });
        return PatientResponse.builder()
                .nama(patientRes.get().getName())
                .nik(patientRes.get().getNik())
                .address(patientRes.get().getAddress())
                .historyVisitList(visitDtoList)
                .build();
    }

    public SaveResponse saveData(SaveRequest request) {
        Boolean isSuccess = true;
        SaveResponse response;
        try {
            if (Objects.nonNull(request.getPatient())) {
                patientRepository.saveAndFlush(request.getPatient());
            } else if (Objects.nonNull(request.getDoctor())) {
                doctorRepository.saveAndFlush(request.getDoctor());
            } else {
                historyVisitRepository.saveAndFlush(request.getHistoryVisit());
            }
        } catch (Exception e) {
            isSuccess = false;
            throw e;
        } finally {
            response = SaveResponse.builder()
                    .isSuccess(isSuccess).build();
        }
       return response;
    }

    public GetDataResponsePagination getListPatient(GetDataRequestPagination request) {
        List<Patient> patientList = new ArrayList<>();
        Page<Patient> patientPage;
        try {
            Pageable paging = PageRequest.of(request.getPageNumber(), request.getPageSize(), Sort.by(request.getDirection().equalsIgnoreCase("asc")? Sort.Direction.ASC: Sort.Direction.DESC, request.getSortBy()));
            patientPage = patientRepository.findAll(paging);
            if (patientPage != null) {
                patientList = patientPage.getContent();
            }
        } catch (Exception e) {
            throw e;
        }

        return GetDataResponsePagination.builder()
                .totalElements(patientPage.getTotalElements())
                .totalPages(patientPage.getTotalPages())
                .numberOfElements(patientPage.getNumberOfElements())
                .pageNumber(patientPage.getNumber())
                .contentPatient(patientList)
                .build();
    }

    public GetDataResponsePagination getListDoctor(GetDataRequestPagination request) {
        List<Doctor> doctorList = new ArrayList<>();
        Page<Doctor> doctorPage;
        try {
            Pageable paging = PageRequest.of(request.getPageNumber(), request.getPageSize(), Sort.by(request.getDirection().equalsIgnoreCase("asc")? Sort.Direction.ASC: Sort.Direction.DESC, request.getSortBy()));
            doctorPage = doctorRepository.findAll(paging);
            if (doctorPage != null) {
                doctorList = doctorPage.getContent();
            }
        } catch (Exception e) {
            throw e;
        }

        return GetDataResponsePagination.builder()
                .totalElements(doctorPage.getTotalElements())
                .totalPages(doctorPage.getTotalPages())
                .numberOfElements(doctorPage.getNumberOfElements())
                .pageNumber(doctorPage.getNumber())
                .contentDoctor(doctorList)
                .build();
    }

    public List<Patient> getPatientList() {
        return patientRepository.findAll();
    }

}
