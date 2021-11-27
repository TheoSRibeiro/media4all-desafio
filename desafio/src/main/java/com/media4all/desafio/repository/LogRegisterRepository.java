package com.media4all.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.media4all.desafio.model.LogRegister;

@Repository
public interface LogRegisterRepository extends JpaRepository<LogRegister, Integer> {

}
