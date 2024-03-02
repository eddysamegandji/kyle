package com.kylemanagement.mapper;

import com.api.model.SkillDto;
import com.kylemanagement.model.Customer;
import com.kylemanagement.model.Skill;
import com.kylemanagement.model.SkillGroup;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import static java.util.Optional.ofNullable;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SkillMapper {

    SkillDto toSkillDto(Skill skill);

    @InheritInverseConfiguration
    Skill toSkill(SkillDto skillDto);

    default Long map(SkillGroup skillGroup) {
        return ofNullable(skillGroup)
                .map(SkillGroup::getSkillGroupId)
                .orElse(null);
    }
    default SkillGroup mapToSkillGroup(Long skillGroupId) {
        if (skillGroupId == null)
            return null;
        SkillGroup skillGroup = new SkillGroup();
        skillGroup.setSkillGroupId(skillGroupId);
        return skillGroup;
    }
}
