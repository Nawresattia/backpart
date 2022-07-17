package com.example.RestApi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.RestApi.entities.Camion;


public interface CamionRepository extends JpaRepository<Camion, Long> {
	
	
	List<Camion>findAll();
	Optional<Camion>findById(Long Id);
	List<Camion>findByTaille(String taille);
	//Camion findByChauffeur(Chauffeur chauffeur);
	
	
	@Query(value = "SELECT * FROM Camion WHERE `id`=?1", nativeQuery = true)
	Camion findByIddata(Long id);

}
