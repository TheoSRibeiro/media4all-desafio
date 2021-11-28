package com.media4all.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.media4all.desafio.model.EndPointRegister;

import java.util.Optional;

@Repository
public interface EndPointRegisterRepository extends JpaRepository<EndPointRegister, Integer> {


    @Query(value = "FROM EndPointRegister epr WHERE epr.content = :endpoint")
    Optional<EndPointRegister> findByEndpoint(String endpoint);
	
}
