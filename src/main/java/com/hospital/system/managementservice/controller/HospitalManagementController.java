package com.hospital.system.managementservice.controller;

import com.hospital.system.managementservice.dto.*;
import com.hospital.system.managementservice.model.Patient;
import com.hospital.system.managementservice.service.HospitalManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HospitalManagementController {

    @Autowired
    private HospitalManagementService service;

    @PostMapping("/getdetailpatient")
    public PatientResponse getDetailPatient(@RequestBody PatientRequest request) {
        return service.getDetailPatientByNik(request);
    }

    @PostMapping("/savedata")
    public SaveResponse saveData(@RequestBody SaveRequest request) {
        return service.saveData(request);
    }

    @PostMapping("/getlistpatient")
    public GetDataResponsePagination getListPatientPagination(@RequestBody GetDataRequestPagination request) {
        return service.getListPatient(request);
    }

    @PostMapping("/getlistdoctor")
    public GetDataResponsePagination getListDoctorPagination(@RequestBody GetDataRequestPagination request) {
        return service.getListDoctor(request);
    }

    @GetMapping("/getlist")
    public List<Patient> getList() {
        return service.getPatientList();
    }
}
