package ru.tech.tech_registry.smartphone.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tech.tech_registry.smartphone.dto.SmartphoneDto;

@Service
@Transactional
public class SmartphoneServiceImpl implements SmartphoneService {

    @Override
    public SmartphoneDto create(SmartphoneDto smartphoneDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public SmartphoneDto update(Long smartId, SmartphoneDto smartphoneDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
