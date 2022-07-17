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
import org.springframework.web.bind.annotation.RestController;


import com.example.RestApi.entities.Maintenance;
import com.example.RestApi.repository.MaintenanceRepository;

 
@CrossOrigin(origins = "*")
@RestController
public class MaintenanceController {

	private final MaintenanceRepository manitenancerepo;

	MaintenanceController(MaintenanceRepository mr) {
		this.manitenancerepo = mr;
	}
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("/AllMaintenance")
	public  List<Maintenance> AllMaintenance() {
		return manitenancerepo.findAll();
	}
	@CrossOrigin(origins = "*")
	@PostMapping("/MaintenanceById")
	public Optional<Maintenance> MaintenanceById(@RequestBody Map<String, String> us) {
		Optional<Maintenance> rec = manitenancerepo.findById(Long.parseLong(us.get("id")));
		return rec;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/CreateMaintenance")
	public Map<String, String> CreateMaintenance(@RequestBody Map<String, String> us) {
		HashMap<String, String> map = new HashMap<>();
		Maintenance maintenance = new Maintenance();
		maintenance.setDemandeur(us.get("Demandeur"));
		
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(us.get("date"));
			maintenance.setDate(date);
		} catch (ParseException e) {
			map.put("key", "error");
			return map;
		}
		
 		//fourrepo.findById(Long.parseLong(id))
		maintenance.setDemandeur(us.get("Demandeur"));
		maintenance.setSite(us.get("Site"));
		manitenancerepo.save(maintenance);
		map.put("key", "done");
		return map;
	
}
	

	@CrossOrigin(origins = "*")
	@PostMapping("/DeleteMaintenance")
	public Map<String, String> DeleteChauffeur(@RequestBody Map<String, String> us) {
		HashMap<String, String> map = new HashMap<>();
		Maintenance maintenance = manitenancerepo.findByIddata(Long.parseLong(us.get("id")));		
		manitenancerepo.delete(maintenance);
		map.put("key", "done");
		return map;
	}

	
	
	
	@CrossOrigin(origins = "*")
	@PostMapping("/UpdateMaintenance")
	public Map<String, String> UpdateChauffeur(@RequestBody Map<String, String> us) {
		HashMap<String, String> map = new HashMap<>();
		Maintenance maintenance = manitenancerepo.findByIddata(Long.parseLong(us.get("id")));	
		if(maintenance!=null) {
			if(us.get("Demandeur")!=null && us.get("Demandeur")!="")
				maintenance.setDemandeur(us.get("Demandeur"));
			Date date;
			try {
				//date="2022-12-25";
				if(us.get("date")!=null && us.get("date")!="")
				{date = new SimpleDateFormat("yyyy-MM-dd").parse(us.get("date"));
				maintenance.setDate(date);}
			} catch (ParseException e) {
				map.put("key", "error");
				return map;
			}
 				if(us.get("Site")!=null && us.get("Site")!="")
				maintenance.setSite(us.get("Site"));
				if(us.get("ReferenceOt")!=null && us.get("ReferenceOt")!="")
				maintenance.setReferenceOt(us.get("ReferenceOt"));
				manitenancerepo.save(maintenance);
				map.put("key", "done");
				return map;
		}
		map.put("key", "not Found");
		return map;
	}
	
	
	
}
	
	
	