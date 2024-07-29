package ru.tech.tech_registry.tv.service;

import ru.tech.tech_registry.tv.dto.TVDto;

import java.util.List;

public interface TVService {
    TVDto create(TVDto tvDto);

    TVDto update(TVDto tvDto);

    TVDto getTVById(Long modelId);

    List<TVDto> getAllTV();

    void deleteById(Long modelId);
}
