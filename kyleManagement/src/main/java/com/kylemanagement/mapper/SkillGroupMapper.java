package com.kylemanagement.mapper;

import com.api.model.SkillGroupDto;
import com.kylemanagement.model.SkillGroup;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)

public interface SkillGroupMapper {

    SkillGroupDto toSkillGroupDto(SkillGroup skillGroup);

    @InheritInverseConfiguration
    @Mapping(target = "skillGroupId", ignore = true)
    SkillGroup toSkillGroup(SkillGroupDto skillGroupDto, @MappingTarget SkillGroup skillGroup);
}
