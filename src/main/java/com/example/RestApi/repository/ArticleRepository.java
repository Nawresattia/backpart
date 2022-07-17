package com.example.RestApi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.RestApi.entities.Article;
import com.example.RestApi.entities.Fournisseur;
import com.example.RestApi.entities.Reception;

public interface ArticleRepository extends JpaRepository<Article,Long> {

	
	List<Article>findAll();
	Optional<Article>findById(Long id);
	List<Article>findByIntitule(String intitule);
	//Article findBYFournisseurs(Fournisseur fournisseur);
	
	@Query(value = "SELECT * FROM article WHERE `id`=?1", nativeQuery = true)
	Article findByIddata(Long id);
	
}
