package com.kylemanagement.service;

import com.api.model.SkillDto;
import java.util.List;

public interface SkillService {

    SkillDto createSkill(SkillDto skill);
    List<SkillDto> getSkills();
    List<SkillDto> getSkillsBySkillGroupId(Long skillGroupId);
}
