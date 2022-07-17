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

import com.example.RestApi.entities.Reception;

import com.example.RestApi.repository.ReceptionRepository;
@RestController
@RequestMapping
public class ReceptionController {

	
	private final ReceptionRepository receptionrepo;

	ReceptionController(ReceptionRepository receptionrepo) {
		this.receptionrepo = receptionrepo;
	}
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("/AllReception")
	
	public  List<Reception>AllReception() {
		return receptionrepo.findAll();
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/ReceptionById")
	public Optional<Reception> ReceptionById(@RequestBody Map<String, String> us) {
		Optional<Reception> rec = receptionrepo.findById(Long.parseLong(us.get("id")));
		return rec;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/CreateReception")
	public Map<String, String> CreateReception(@RequestBody Map<String, String> us) {
		HashMap<String, String> map = new HashMap<>();
		Reception reception = new Reception();
		reception.setHeure_arrive(us.get("Heure_arrive"));
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(us.get("date"));
			reception.setDate(date);
		} catch (ParseException e) {
			map.put("key", "error");
			return map;
		}
 		reception.setEntrepot(us.get("Entrepot"));
		receptionrepo.save(reception);
		map.put("key", "done");
		return map;
	}


	@CrossOrigin(origins = "*")
	@PostMapping("/DeleteReception")
	public Map<String, String> DeleteReception(@RequestBody Map<String, String> us) {
		HashMap<String, String> map = new HashMap<>();
		Reception reception = receptionrepo.findByIddata(Long.parseLong(us.get("id")));		
		receptionrepo.delete(reception);
		map.put("key", "done");
		return map;
	}	
	
	
	
	
	@CrossOrigin(origins = "*")
	@PostMapping("/UpdateReception")
	public Map<String, String> UpdateReception(@RequestBody Map<String, String> us) {
		HashMap<String, String> map = new HashMap<>();
		Reception reception = receptionrepo.findByIddata(Long.parseLong(us.get("id")));	
		if(reception!=null) {
			if(us.get("Entrepot")!=null && us.get("entrepot")!="")
				reception.setEntrepot(us.get("Entrepot"));
				Date date;
				try {
					//date="2022-12-25";
					if(us.get("date")!=null && us.get("date")!="")
					{date = new SimpleDateFormat("yyyy-MM-dd").parse(us.get("date"));
					reception.setDate(date);}
				} catch (ParseException e) {
					map.put("key", "error");
					return map;
				}
				 
				if(us.get("Heure_arrive")!=null && us.get("Heure_arrive")!="")
				reception.setHeure_arrive(us.get("Heure_arrive"));
				receptionrepo.save(reception);
				map.put("key", "done");
				return map;
		}
		map.put("key", "not Found");
		return map;
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/ajouterReception")
	@ResponseBody
	public Reception ajouterReception(@RequestBody Reception Fou) {
		return receptionrepo.save(Fou);
	}		 
	
	
		
}

