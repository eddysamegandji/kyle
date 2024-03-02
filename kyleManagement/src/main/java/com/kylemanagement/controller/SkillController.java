package com.kylemanagement.controller;

import com.api.handler.SkillResourceApi;
import com.api.model.SkillDto;
import com.kylemanagement.mapper.SkillMapper;
import com.kylemanagement.service.SkillService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class SkillController implements SkillResourceApi {

    final SkillService skillService;
    final SkillMapper skillMapper;

    @Override
    public ResponseEntity<SkillDto> createSkill(SkillDto skillDto) {
        return null;
    }

    @Override
    public ResponseEntity<List<SkillDto>> getSkill(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<SkillDto>> getSkills() {
        List<SkillDto> skillDtos = skillService.getSkills()
                .stream()
                .map(skillMapper::toSkillDto)
                .toList();
        return skillDtos.isEmpty() ? noContent().build() : ok(skillDtos);
    }

    @Override
    public ResponseEntity<List<SkillDto>> getSkillsBySkillGroupId(Long skillGroupId) throws Exception {
        List<SkillDto> skillDtos = skillService.getSkillsBySkillGroupId(skillGroupId);
        return skillDtos.isEmpty() ? noContent().build() : ok(skillDtos);
    }
}
