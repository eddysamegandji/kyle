package com.kylemanagement.service.impl;

import com.api.model.SkillDto;
import com.kylemanagement.mapper.SkillMapper;
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
    final SkillMapper skillMapper;

    @Override
    public Skill saveSkill(Skill skill) {
        return null;
    }

    @Override
    public List<Skill> getSkills() {
        return skillRepository.findAll();
    }

    @Override
    public List<SkillDto> getSkillsBySkillGroupId(Long skillGroupId) {
        return skillRepository.findBySkillGroupId(skillGroupId)
                .stream()
                .map(skillMapper::toSkillDto)
                .toList();
    }
}

