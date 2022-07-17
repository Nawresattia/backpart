package com.example.RestApi.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.RestApi.entities.Chauffeur;
import com.example.RestApi.entities.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {

	List<Maintenance>findAll();
	Optional<Maintenance>findById(Long id);
	//List<Maintenance>findBySite();
	@Query(value = "SELECT * FROM Maintenance WHERE `site`=?1", nativeQuery = true)
	List<Maintenance>findBySite(String site);
	
	Maintenance findByDate(  Date date);
	
	
	@Query(value = "SELECT * FROM Maintenance WHERE `id`=?1", nativeQuery = true)
	Maintenance findByIddata(Long id);

	
}
