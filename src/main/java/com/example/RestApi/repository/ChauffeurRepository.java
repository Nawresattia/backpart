package com.example.RestApi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.RestApi.entities.Camion;
import com.example.RestApi.entities.Chauffeur;

public interface ChauffeurRepository extends JpaRepository<Chauffeur, Long> {
	
	List<Chauffeur>findAll();
	Optional<Chauffeur>findById(Long Id);
	List<Chauffeur>findByNomchauffeur(String nomchauffeur);
	//Chauffeur findByChauffeur(Chauffeur chauffeur);
	

	@Query(value = "SELECT * FROM Chauffeur WHERE `id`=?1", nativeQuery = true)
	Chauffeur findByIddata(Long id);

}
