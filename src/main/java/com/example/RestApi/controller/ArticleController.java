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
import com.example.RestApi.repository.ArticleRepository;
 


@CrossOrigin(origins = "*")
@RestController
public class ArticleController {
	private final ArticleRepository articlerepo;

	ArticleController(ArticleRepository articlerepo) {
		this.articlerepo = articlerepo;
	}


	
	@CrossOrigin(origins = "*")
	@GetMapping("/AllArticle")
	public  List<Article> AllArticle() {
		return articlerepo.findAll();
		
	}
	
	
	
	
	@CrossOrigin(origins = "*")
	@PostMapping("/ArticleById")
	public Optional<Article> ArticleById(@RequestBody Map<String, String> us) {
		Optional<Article> rec = articlerepo.findById(Long.parseLong(us.get("id")));
		return rec;
	}
	

	
	@CrossOrigin(origins = "*")
	 @DeleteMapping("/DeleteArticle/{id}")
	  void deleteArticle(@PathVariable Long id) {
		articlerepo.deleteById(id);
	  }
	
	
	@CrossOrigin(origins = "*")
	@GetMapping("/Article/{id}")
	@ResponseBody
	public Article retriveArticle(@PathVariable("id") Long id) {
		
		return articlerepo.findByIddata(id);
	}
	@PutMapping("/updateArticle/{id}")  
    public ResponseEntity<Article> updateArticle(@RequestBody Article cat,@PathVariable("id") Long id) {  
		Optional<Article> articledata=articlerepo.findById(id);
		if(articledata.isPresent()) {
			Article article=articledata.get();
			article.setCode(cat.getCode());
			article.setIntitule(cat.getIntitule());
			article.setFournisseurs(cat.getFournisseurs());
			article.setDatecreation(cat.getDatecreation());
		
			return new ResponseEntity<>(articlerepo.save(article),HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
        
    }  
	@PostMapping("/InsertArticle")
	@ResponseBody
	public Article modifierArticle(@RequestBody Article art) {
		return articlerepo.save(art);
	}		 
	
}
