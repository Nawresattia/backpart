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

import com.example.RestApi.entities.Article;
import com.example.RestApi.entities.Camion;
import com.example.RestApi.entities.Fournisseur;
 import com.example.RestApi.repository.FournisseurRepository;

 
 
@CrossOrigin(origins = "*")
@RestController
public class FournisseurController {
 
	private final FournisseurRepository fournisseurrepo;

	FournisseurController(FournisseurRepository fournisseurrepo) {
		this.fournisseurrepo = fournisseurrepo;
	}


	@CrossOrigin(origins = "*")
	@GetMapping("/AllFournisseur")
	public  List<Fournisseur> AllFournisseur() {
		return fournisseurrepo.findAll();
	}
	@CrossOrigin(origins = "*")
	@PostMapping("/FournisseurById")
	public Optional<Fournisseur> ArticleById(@RequestBody Map<String, String> us) {
		Optional<Fournisseur> rec = fournisseurrepo.findById(Long.parseLong(us.get("id")));
		return rec;
	}
	
	

	@CrossOrigin(origins = "*")
	 @DeleteMapping("/DeleteFournisseur/{id}")
	  void deleteFournisseur(@PathVariable Long id) {
		fournisseurrepo.deleteById(id);
	  }
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("/Fournisseur/{id}")
	@ResponseBody
	public Fournisseur retriveFournisseur(@PathVariable("id") Long id) {
		
		return fournisseurrepo.findByIddata(id);
	}
	@PutMapping("/updatefournisseur/{id}")  
    public ResponseEntity<Fournisseur> updateFournisseur(@RequestBody Fournisseur cat,@PathVariable("id") Long id) {  
		Optional<Fournisseur> articledata=fournisseurrepo.findById(id);
		if(articledata.isPresent()) {
			Fournisseur fournisseur=articledata.get();
			fournisseur.setCode(cat.getCode());
			fournisseur.setNom(cat.getNom());
			fournisseur.setType(cat.getType());
			fournisseur.setDatecreation(cat.getDatecreation());
		
			return new ResponseEntity<>(fournisseurrepo.save(fournisseur),HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
        
    }  

	@PostMapping("/InsertFournisseur")
	@ResponseBody
	public Fournisseur modifierFournisseur(@RequestBody Fournisseur Fou) {
		return fournisseurrepo.save(Fou);
	}		 
	
}
