package com.example.RestApi.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.RestApi.entities.Fournisseur;
import com.example.RestApi.entities.Reception;

public interface ReceptionRepository extends JpaRepository<Reception, Long> {

	List<Reception>findAll();
	Optional<Reception>findById(Long id);
	List<Reception>findByDate(Date date);
	//Reception findBYFournisseurs(Fournisseur Fournisseurs);
	
	@Query(value = "SELECT * FROM reception WHERE `id`=?1", nativeQuery = true)
	
	Reception findByIddata(Long id);
	
	@Query(value = "select COUNT(*) from reception a where a.date > ?1 AND a.date < ?2", nativeQuery = true)
	public Long CountReception(Date infdate,Date supdate);

}
