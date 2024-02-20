package com.kylemanagement.service;

import com.kylemanagement.model.Skill;
import java.util.List;

public interface SkillService {

    Skill saveSkill(Skill skill);
    List<Skill> getSkills();
}
