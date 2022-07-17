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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestApi.entities.Fournisseur;
import com.example.RestApi.entities.Reception;
import com.example.RestApi.entities.ReceptionCourriers;
import com.example.RestApi.repository.ReceptionCourriersRepository;
@RestController
@RequestMapping
public class ReceptionCourriersController {
	private final ReceptionCourriersRepository receptionCourriersrepo;

	ReceptionCourriersController(ReceptionCourriersRepository receptionCourriersrepo) {
		this.receptionCourriersrepo = receptionCourriersrepo;
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/AllReceptionCourriers")
	public  List<ReceptionCourriers> AllReceptionCourriers() {
		return receptionCourriersrepo.findAll();
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/ReceptionCourriersById")
	public Optional<ReceptionCourriers> ReceptionById(@RequestBody Map<String, String> us) {
		Optional<ReceptionCourriers> rec = receptionCourriersrepo.findById(Long.parseLong(us.get("id")));
		return rec;
	}
	
	
	@CrossOrigin(origins = "*")
	@PostMapping("/DeleteReceptionCourriers")
	public Map<String, String> DeleteReceptionCourriers(@RequestBody Map<String, String> us) {
		HashMap<String, String> map = new HashMap<>();
		ReceptionCourriers reception = receptionCourriersrepo.findByIddata(Long.parseLong(us.get("id")));		
		receptionCourriersrepo.delete(reception);
		map.put("key", "done");
		return map;
	}	
	
	
	

	
	
		
}
