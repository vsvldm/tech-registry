package ru.tech.tech_registry.refrigerator.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tech.tech_registry.refrigerator.dto.RefrigeratorDto;

@Service
@Transactional
public class RefrigeratorServiceImpl implements RefrigeratorService {

    @Override
    public RefrigeratorDto create(RefrigeratorDto refrigeratorDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public RefrigeratorDto update(Long refId, RefrigeratorDto refrigeratorDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
