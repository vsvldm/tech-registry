package ru.tech.tech_registry.tv.service;

import ru.tech.tech_registry.tv.dto.TVDto;

public interface TVService {
    TVDto create(TVDto tvDto);

    TVDto update(Long tvId, TVDto tvDto);
}
