package com.media4all.desafio.service.impl;

import com.media4all.desafio.model.EndPointRegister;
import com.media4all.desafio.model.LogRegister;
import com.media4all.desafio.repository.EndPointRegisterRepository;
import com.media4all.desafio.service.EndPointRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EndPointRegisterServiceImpl implements EndPointRegisterService {

    @Autowired
    private EndPointRegisterRepository repository;

    @Override
    public EndPointRegister create(EndPointRegister endPointRegister) {
        return repository.save(endPointRegister);
    }
}
