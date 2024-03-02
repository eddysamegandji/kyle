package com.kylemanagement.mapper;

import com.api.model.SkillDto;
import com.kylemanagement.model.Skill;
import org.mapstruct.*;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SkillMapper {

    SkillDto toSkillDto(Skill skill);

    @InheritInverseConfiguration
    @Mapping(target = "skillId", ignore = true)
    Skill toSkill(SkillDto skillDto, @MappingTarget Skill skill);
}
