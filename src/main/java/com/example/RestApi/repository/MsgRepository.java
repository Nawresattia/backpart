package com.example.RestApi.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.RestApi.entities.Msg;

public interface MsgRepository extends JpaRepository<Msg, Long> {

	
	List<Msg>findAll();
	Optional<Msg>findById(Long id);
	List<Msg>findByDate(Date date);
	@Query(value = "SELECT * FROM msg WHERE `reciver`=?1 && `sender`=?2 || `sender`=?1 && `reciver`=?2 ORDER BY date ASC", nativeQuery = true)
	List<Msg> getMsg(String receiver, String sender);
	
	
}
