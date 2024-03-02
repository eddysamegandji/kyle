package com.kylemanagement.controller;

import com.api.handler.SkillGroupResourceApi;
import com.api.model.SkillGroupDto;
import com.kylemanagement.service.SkillGroupService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class SkillGroupController implements SkillGroupResourceApi {

    final SkillGroupService skillGroupService;

    @Override
    public ResponseEntity<SkillGroupDto> createSkillGroup(SkillGroupDto skillGroupDto) {
        SkillGroupDto newSkillGroup = skillGroupService.createSkillGroup(skillGroupDto);
        return newSkillGroup == null ? badRequest().build() : ResponseEntity.status(HttpStatus.CREATED).body(newSkillGroup);
    }

    @Override
    public ResponseEntity<SkillGroupDto> editSkillGroup(Long id, SkillGroupDto skillGroupDto) {
        SkillGroupDto updatedSkillGroup = skillGroupService.updateSkillGroup(id, skillGroupDto);
        return updatedSkillGroup == null ? notFound().build() : ok(updatedSkillGroup);
    }

    @Override
    public ResponseEntity<SkillGroupDto> getSkillGroup(Long id) {
        SkillGroupDto skillGroupDto = skillGroupService.getSkillGroupById(id);
        return skillGroupDto == null ? notFound().build() : ok(skillGroupDto);
    }

    @Override
    public ResponseEntity<List<SkillGroupDto>> getSkillGroups() {
        List<SkillGroupDto> skillGroupDtos = skillGroupService.getSkillGroups();
        return skillGroupDtos.isEmpty() ? noContent().build() : ok(skillGroupDtos);
    }

    @Override
    public ResponseEntity<Void> deleteSkillGroup(Long id) {
        boolean deleted = skillGroupService.deleteSkillGroupById(id);
        return deleted ? noContent().build() : notFound().build();
    }
}
