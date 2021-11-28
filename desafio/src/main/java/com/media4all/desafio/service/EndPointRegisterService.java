package com.media4all.desafio.service;

import com.media4all.desafio.model.EndPointRegister;
import com.media4all.desafio.model.LogRegister;

import java.util.Optional;

public interface EndPointRegisterService {

    EndPointRegister create (EndPointRegister endPointRegister) throws Exception;
    Optional<EndPointRegister> findByEndpoint(String endpoint);
}
