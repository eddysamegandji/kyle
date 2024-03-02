package com.kylemanagement.service.impl;

import com.api.model.SkillGroupDto;
import com.kylemanagement.mapper.SkillGroupMapper;
import com.kylemanagement.model.SkillGroup;
import com.kylemanagement.model.User;
import com.kylemanagement.repository.SkillGroupRepository;
import com.kylemanagement.service.SkillGroupService;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillGroupServiceImpl implements SkillGroupService {

    final SkillGroupRepository skillGroupRepository;
    final SkillGroupMapper skillGroupMapper;
    final UserDetailsService userDetailsService;

    @Override
    public SkillGroupDto createSkillGroup(SkillGroupDto skillGroupDto) {
        SkillGroup skillGroup = skillGroupMapper.toSkillGroup(skillGroupDto, new SkillGroup());
        skillGroup.setCreationUser((User) userDetailsService.loadUserByUsername("admin"));
        skillGroup.setCreationDate(Instant.now());
        skillGroup.setLastModifiedDate(Instant.now());
        skillGroup.setLastModifiedUser((User) userDetailsService.loadUserByUsername("admin"));
        return skillGroupMapper.toSkillGroupDto(skillGroupRepository.save(skillGroup));
    }

    @Override
    public SkillGroupDto updateSkillGroup(Long skillGroupId, SkillGroupDto skillGroupDto) {
        Optional<SkillGroup> existingSkillGroup = skillGroupRepository.findById(skillGroupId);
        if (existingSkillGroup.isPresent()) {
            SkillGroup toUpdate = skillGroupMapper.toSkillGroup(skillGroupDto, existingSkillGroup.get());
            toUpdate.setLastModifiedDate(Instant.now());
            toUpdate.setLastModifiedUser((User) userDetailsService.loadUserByUsername("admin"));
            return skillGroupMapper.toSkillGroupDto(skillGroupRepository.save(toUpdate));
        }
        return null;
    }

    @Override
    public List<SkillGroupDto> getSkillGroups() {
        return skillGroupRepository.findAll()
                .stream()
                .map(skillGroupMapper::toSkillGroupDto)
                .toList();
    }

    @Override
    public SkillGroupDto getSkillGroupById(Long skillGroupId) {
        return skillGroupRepository.findById(skillGroupId)
                .map(skillGroupMapper::toSkillGroupDto)
                .orElse(null);
    }

    @Override
    public boolean deleteSkillGroupById(Long skillGroupId) {
        Optional<SkillGroup> existingSkillGroup = skillGroupRepository.findById(skillGroupId);
        existingSkillGroup.ifPresent(skillGroupRepository::delete);
        return existingSkillGroup.isPresent();
    }
}
