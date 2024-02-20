package com.kylemanagement.mapper;

import com.api.model.SkillDto;
import com.kylemanagement.model.Skill;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SkillMapper {

    SkillDto toSkillDto(Skill skill);

    @InheritInverseConfiguration
    Skill toSkill(SkillDto skillDto);
}
