package com.example.demo.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Patient;
import com.example.demo.Repository.PatientRepository;
import com.example.demo.exception.RequestNotFoundException;









@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PatientController {

	@Autowired
	PatientRepository repo;
	
	@GetMapping("/Patient")
	public List<Patient> getAllPatients(){
		return repo.findAll();
	}

	@PostMapping("/Patient")
	public Patient createpatinet(@RequestBody Patient patient) {
		return repo.save(patient);
	}
	
	@GetMapping("/Patient/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
		Patient patient = repo.findById(id)
				.orElseThrow(() -> new RequestNotFoundException("Patient not exist with id :" + id));
		return ResponseEntity.ok(patient);
	}
	
	@PutMapping("/Patient/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails){
		Patient patient = repo.findById(id)
				.orElseThrow(() -> new RequestNotFoundException("Patient not exist with id :" + id));
		
		patient.setFname(patientDetails.getFname());
		patient.setLname(patientDetails.getLname());
		patient.setEmailId(patientDetails.getEmailId());
		patient.setMobile(patientDetails.getMobile());
		patient.setDob(patientDetails.getDob());
		patient.setBloodgroup(patientDetails.getBloodgroup());
		patient.setAddress(patientDetails.getAddress());
		Patient updatedPatient = repo.save(patient);
		return ResponseEntity.ok(updatedPatient);
	}
	
	@DeleteMapping("/Patient/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable Long id){
		Patient patient = repo.findById(id)
				.orElseThrow(() -> new RequestNotFoundException("Patient not exist with id :" + id));
		
		repo.delete(patient);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
