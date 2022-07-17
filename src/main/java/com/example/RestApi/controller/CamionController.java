package com.example.RestApi.controller;
 

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.RestApi.entities.Camion;
import com.example.RestApi.repository.CamionRepository;

 
@CrossOrigin(origins = "*")
@RestController
public class CamionController {

	private final CamionRepository camionrepo;

	CamionController(CamionRepository camionrepo) {
		this.camionrepo = camionrepo;
	}


	@CrossOrigin(origins = "*")
	@GetMapping("/AllCamion")
	public  List<Camion> AllCamion() {
		
		return camionrepo.findAll();
	}
	@CrossOrigin(origins = "*")
	@PostMapping("/CamionById")
	public Optional<Camion> ArticleById(@RequestBody Map<String, String> us) {
		Optional<Camion> rec = camionrepo.findById(Long.parseLong(us.get("id")));
		return rec;
	}
	
	

	
	@CrossOrigin(origins = "*")
	 @DeleteMapping("/DeleteCamion/{id}")
	  void deleteCamion(@PathVariable Long id) {
	    camionrepo.deleteById(id);
	  }
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("/Cammion/{id}")
	@ResponseBody
	public Camion retriveCamion(@PathVariable("id") Long id) {
		
		return camionrepo.findByIddata(id);
	}
	@PutMapping("/modifyCamion/{id}")
	@ResponseBody
	public Camion modifierCamion(@PathVariable("id") Long id,@RequestBody Camion cat) {
		return camionrepo.save(cat);
	}

	@PostMapping("/InsertCamion")
	@ResponseBody
	public Camion modifierCamion(@RequestBody Camion cat) {
		return camionrepo.save(cat);
	}		 
	@PutMapping("/update/{id}")  
    public ResponseEntity<Camion> updateCamion(@RequestBody Camion cat,@PathVariable("id") Long id) {  
		Optional<Camion> camiondata=camionrepo.findById(id);
		if(camiondata.isPresent()) {
			Camion camion=camiondata.get();
			camion.setImmatricule(cat.getImmatricule());
			camion.setTaille(cat.getTaille());
			camion.setType(cat.getType());
			camion.setChauffeur(cat.getChauffeur());
			camion.setDatecreation(cat.getDatecreation());
			return new ResponseEntity<>(camionrepo.save(camion),HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
        
    }  
}
