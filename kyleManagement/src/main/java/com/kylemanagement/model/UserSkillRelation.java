package com.kylemanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "userskillrelation")
@Data
public class UserSkillRelation {

    @Id
    @ManyToOne
    @JoinColumn(name="userId", referencedColumnName="userId")
    private User user;
    @Id
    @ManyToOne
    @JoinColumn(name="skillId", referencedColumnName="skillId")
    private Skill skill;

}
