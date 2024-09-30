package ru.digitalhabits.homework3.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.digitalhabits.homework3.domain.Department;
import ru.digitalhabits.homework3.model.DepartmentFullResponse;
import ru.digitalhabits.homework3.model.DepartmentRequest;
import ru.digitalhabits.homework3.model.DepartmentShortResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    @Mapping(target = "persons", source = "personList")
    @Mapping(target = "closed", source = "isClosed")
    DepartmentFullResponse map(Department department);

    @Mapping(target = "isClosed", source = "closed")
    Department map(DepartmentRequest request);

    @Mapping(target = "isClosed", source = "closed")
    Department map(@MappingTarget Department department, DepartmentRequest request);

    List<DepartmentShortResponse> mapToShort(List<Department> departments);
}
