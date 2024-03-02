package com.kylemanagement.mapper;

import com.api.model.SkillGroupDto;
import com.kylemanagement.model.SkillGroup;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface SkillGroupMapper {

    SkillGroupDto toSkillGroupDto(SkillGroup skillGroup);

    @InheritInverseConfiguration
    SkillGroup toSkillGroup(SkillGroupDto skillGroupDto);
}
