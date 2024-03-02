package com.kylemanagement.service;

import com.api.model.SkillDto;
import com.kylemanagement.model.Skill;
import java.util.List;

public interface SkillService {

    Skill saveSkill(Skill skill);
    List<Skill> getSkills();
    List<SkillDto> getSkillsBySkillGroupId(Long skillGroupId);
}
