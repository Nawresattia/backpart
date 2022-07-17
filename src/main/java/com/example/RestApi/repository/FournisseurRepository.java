package com.example.RestApi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.RestApi.entities.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

	List<Fournisseur>findAll();
	Optional<Fournisseur>findById(Long id);
	//List<Fournisseur>findByNom(String nom);
	Fournisseur findByType(String type);
	@Query(value = "SELECT * FROM Fournisseur WHERE `nom`=?1", nativeQuery = true)
	List<Fournisseur> findByNom(String nom);
	
	@Query(value = "SELECT * FROM Fournisseur WHERE `id`=?1", nativeQuery = true)
	Fournisseur findByIddata(Long id);

}
