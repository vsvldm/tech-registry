package ru.tech.tech_registry.tv.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tech.tech_registry.tv.dto.TVDto;

@Service
@Transactional
public class TVServiceImpl implements TVService {

    @Override
    public TVDto create(TVDto tvDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public TVDto update(Long tvId, TVDto tvDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
