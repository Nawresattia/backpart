package com.example.RestApi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestApi.entities.Camion;
import com.example.RestApi.entities.ParcRoulant;

import com.example.RestApi.repository.ParcRoulantRepository;

  
@CrossOrigin(origins = "*")
@RestController
public class ParcRoulantController {

	private final ParcRoulantRepository ParcRoulancerepo;

	ParcRoulantController(ParcRoulantRepository prr) {
		this.ParcRoulancerepo = prr;
	}
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("/AllParcRoulant")
	public  List<ParcRoulant> AllParcRoulant() {
		return ParcRoulancerepo.findAll();
	}
	@CrossOrigin(origins = "*")
	@PostMapping("/ParcRoulantById")
	public Optional<ParcRoulant> ParcRoulantById(@RequestBody Map<String, String> us) {
		Optional<ParcRoulant> rec = ParcRoulancerepo.findById(Long.parseLong(us.get("id")));
		return rec;
	}
	
	
	
	@PostMapping("/InsertParcRoulant")
	@ResponseBody
	public ParcRoulant insertParcRoulant(@RequestBody ParcRoulant par) {
		return ParcRoulancerepo.save(par);
	}		 
}