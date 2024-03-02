package com.kylemanagement.repository;

import com.kylemanagement.model.Skill;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    @Query("select s from Skill s where s.skillGroup.skillGroupId = ?1")
    List<Skill> findBySkillGroupId(Long skillGroupId);
}