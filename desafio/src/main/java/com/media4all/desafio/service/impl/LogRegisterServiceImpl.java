package com.media4all.desafio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.media4all.desafio.model.LogRegister;
import com.media4all.desafio.repository.LogRegisterRepository;
import com.media4all.desafio.service.LogRegisterService;

@Service
public class LogRegisterServiceImpl implements LogRegisterService {

	@Autowired
    private LogRegisterRepository repository;

    @Override
    public LogRegister create(LogRegister logRegister) {
        return repository.save(logRegister);
    }
}
