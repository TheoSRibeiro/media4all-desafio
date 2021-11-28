package com.media4all.desafio.service.impl;

import com.media4all.desafio.model.EndPointRegister;
import com.media4all.desafio.model.LogRegister;
import com.media4all.desafio.repository.EndPointRegisterRepository;
import com.media4all.desafio.service.EndPointRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EndPointRegisterServiceImpl implements EndPointRegisterService {

    @Autowired
    private EndPointRegisterRepository repository;

    @Override
    public EndPointRegister create(EndPointRegister endPointRegister) throws Exception {

        //VERIFICAR SE JÁ EXISTE ENDPOINT CADASTRADO
        Optional<EndPointRegister> optionalEndPointRegister = findByEndpoint(endPointRegister.getContent());

        if(optionalEndPointRegister.isPresent()){
            throw new Exception("Endpoint já Cadastrado!");
        }else{
            return repository.save(endPointRegister);
        }
    }

    @Override
    public Optional<EndPointRegister> findByEndpoint(String endpoint) {
        return repository.findByEndpoint(endpoint);
    }
}
