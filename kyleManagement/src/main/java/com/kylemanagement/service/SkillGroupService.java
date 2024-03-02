package com.kylemanagement.service;

import com.api.model.SkillGroupDto;
import java.util.List;

public interface SkillGroupService {

    SkillGroupDto createSkillGroup(SkillGroupDto skillGroupDto);
    SkillGroupDto updateSkillGroup(Long skillGroupId, SkillGroupDto skillGroupDto);
    List<SkillGroupDto> getSkillGroups();
    SkillGroupDto getSkillGroupById(Long skillGroupId);
    boolean deleteSkillGroupById(Long skillGroupId);
}
