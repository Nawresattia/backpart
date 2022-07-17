package com.example.RestApi.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.RestApi.entities.Camion;
import com.example.RestApi.entities.Chauffeur;
import com.example.RestApi.entities.Maintenance;
import com.example.RestApi.entities.ParcRoulant;
import com.example.RestApi.entities.Reception;
 

public interface ParcRoulantRepository extends JpaRepository<ParcRoulant, Long> {

	
	List<ParcRoulant>findAll();
	Optional<ParcRoulant>findById(Long id);
	//List<ParcRoulant>findByCamion(Camion camion);
	//ParcRoulant findBYChauffeur(Chauffeur chauffeur);
	@Query(value = "SELECT * FROM ParcRoulant WHERE `id`=?1", nativeQuery = true)
	ParcRoulant findByIddata(Long id);
	
	@Query(value = "select COUNT(*) from parc_roulant a where a.date > ?1 AND a.date < ?2", nativeQuery = true)
	public Long CountParcRoulant(Date xww,Date xw);
}
