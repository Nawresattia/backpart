package com.example.RestApi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.RestApi.entities.Article;
import com.example.RestApi.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

	List < User > findAll();	
	Optional<User> findById(Long id);
	List < User > findByRole(String role);
	User findByEmail(String email);


	 @Query(value = "SELECT * FROM user WHERE `id`=?1", nativeQuery = true)
	 User findByByIdCust(Long id);

}


