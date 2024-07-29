package ru.tech.tech_registry.model.mapper;

import org.mapstruct.Mapper;
import ru.tech.tech_registry.computer.dto.ComputerDto;
import ru.tech.tech_registry.computer.model.Computer;
import ru.tech.tech_registry.model.dto.ModelDto;
import ru.tech.tech_registry.model.model.Model;
import ru.tech.tech_registry.refrigerator.dto.RefrigeratorDto;
import ru.tech.tech_registry.refrigerator.model.Refrigerator;
import ru.tech.tech_registry.smartphone.dto.SmartphoneDto;
import ru.tech.tech_registry.smartphone.model.Smartphone;
import ru.tech.tech_registry.tv.dto.TVDto;
import ru.tech.tech_registry.tv.model.TV;
import ru.tech.tech_registry.vacuum_cleaner.dto.VacuumCleanerDto;
import ru.tech.tech_registry.vacuum_cleaner.model.VacuumCleaner;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModelMapper {
    TVDto toTVDto(TV tv);
    VacuumCleanerDto toVacuumCleanerDto(VacuumCleaner vacuumCleaner);
    ComputerDto toComputerDto(Computer computer);
    SmartphoneDto toSmartphoneDto(Smartphone smartphone);
    RefrigeratorDto toRefrigeratorDto(Refrigerator refrigerator);
    ModelDto toModelDto(Model model);
    List<ModelDto> toModelDtos(List<Model> models);

    Model toModel(ModelDto modelDto);
    List<Model> toModels(List<ModelDto> modelDtos);
    TV toTV(TVDto tvDto);
    VacuumCleaner toVacuumCleaner(VacuumCleanerDto vacuumCleanerDto);
    Computer toComputer(ComputerDto computerDto);
    Smartphone toSmartphone(SmartphoneDto smartphoneDto);
    Refrigerator toRefrigerator(RefrigeratorDto refrigeratorDto);
}
