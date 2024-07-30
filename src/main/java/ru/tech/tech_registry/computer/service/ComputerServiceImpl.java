package ru.tech.tech_registry.computer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.tech.tech_registry.computer.dto.ComputerDto;
import ru.tech.tech_registry.computer.repository.ComputerRepository;

@Service
@Transactional
public class ComputerServiceImpl implements ComputerService {
    @Autowired
    private ComputerRepository computerRepository;

    @Override
    public ComputerDto create(ComputerDto computerDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ComputerDto update(Long compId, ComputerDto computerDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
