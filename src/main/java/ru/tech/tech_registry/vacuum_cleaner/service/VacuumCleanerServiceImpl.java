package ru.tech.tech_registry.vacuum_cleaner.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tech.tech_registry.vacuum_cleaner.dto.VacuumCleanerDto;

@Service
@Transactional
public class VacuumCleanerServiceImpl implements VacuumCleanerService {

    @Override
    public VacuumCleanerDto create(VacuumCleanerDto vacuumCleanerDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public VacuumCleanerDto update(Long cleanerId, VacuumCleanerDto vacuumCleanerDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
