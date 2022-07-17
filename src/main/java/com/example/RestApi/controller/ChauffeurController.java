package com.example.RestApi.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import com.example.RestApi.entities.Chauffeur;
import com.example.RestApi.entities.Fournisseur;
import com.example.RestApi.repository.ChauffeurRepository;


 
@CrossOrigin(origins = "*")
@RestController
public class ChauffeurController {
	private final ChauffeurRepository chauffeurrepo;

	ChauffeurController(ChauffeurRepository chauffeurrepo) {
		this.chauffeurrepo = chauffeurrepo;
	}


	@CrossOrigin(origins = "*")
	@GetMapping("/AllChauffeur")
	public  List<Chauffeur> AllChauffeur() {
		return chauffeurrepo.findAll();
	}
	@CrossOrigin(origins = "*")
	@PostMapping("/ChauffeurById")
	public Optional<Chauffeur> ArticleById(@RequestBody Map<String, String> us) {
		Optional<Chauffeur> rec = chauffeurrepo.findById(Long.parseLong(us.get("id")));
		return rec;
	}
	
	

	
	@CrossOrigin(origins = "*")
	 @DeleteMapping("/DeleteChauffeur/{id}")
	  void deleteChauffeur(@PathVariable Long id) {
		chauffeurrepo.deleteById(id);
	  }
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("/Chauffeur/{id}")
	@ResponseBody
	public Chauffeur retriveCamion(@PathVariable("id") Long id) {
		
		return chauffeurrepo.findByIddata(id);
	}
	@PutMapping("/updatechauffeur/{id}")  
    public ResponseEntity<Chauffeur> updateFournisseur(@RequestBody Chauffeur cat,@PathVariable("id") Long id) {  
		Optional<Chauffeur> chauffdata=chauffeurrepo.findById(id);
		if(chauffdata.isPresent()) {
			Chauffeur chauff=chauffdata.get();
			chauff.setNomchauffeur(cat.getNomchauffeur());
			chauff.setPrenomchauffeur(cat.getPrenomchauffeur());
			chauff.setCin(cat.getCin());
			chauff.setSite(cat.getSite());

			chauff.setTel(cat.getTel());

			chauff.setCreatedat(cat.getCreatedat());
		
			return new ResponseEntity<>(chauffeurrepo.save(chauff),HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
        
    }  


	@PostMapping("/InsertChauffeur")
	@ResponseBody
	public Chauffeur modifierChauffeur(@RequestBody Chauffeur chau) {
		return chauffeurrepo.save(chau);
	}		 
	
}
