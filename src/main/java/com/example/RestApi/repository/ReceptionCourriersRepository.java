package com.example.RestApi.repository;



import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.RestApi.entities.Reception;
import com.example.RestApi.entities.ReceptionCourriers;

public interface ReceptionCourriersRepository extends JpaRepository<ReceptionCourriers, Long> {

	
	List<ReceptionCourriers>findAll();
	Optional<ReceptionCourriers>findById(Long id);
	List<ReceptionCourriers>findByDate(Date date);
	@Query(value = "SELECT * FROM ReceptionCourriers WHERE `Entrepot`=?1", nativeQuery = true)
	ReceptionCourriers findBYEntrepot( String Entrepot );
	
	@Query(value = "SELECT * FROM ReceptionCourriers WHERE `id`=?1", nativeQuery = true)
	ReceptionCourriers findByIddata(Long id);
}