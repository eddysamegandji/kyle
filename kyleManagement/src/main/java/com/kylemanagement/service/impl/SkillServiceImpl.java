package com.kylemanagement.service.impl;

import com.kylemanagement.model.Skill;
import com.kylemanagement.repository.SkillRepository;
import com.kylemanagement.service.SkillService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    final SkillRepository skillRepository;

    @Override
    public Skill saveSkill(Skill skill) {
        return null;
    }

    @Override
    public List<Skill> getSkills() {
        return skillRepository.findAll();
    }
}
