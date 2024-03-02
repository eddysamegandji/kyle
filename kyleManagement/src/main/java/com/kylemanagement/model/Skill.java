package com.kylemanagement.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.Calendar;
import lombok.Data;

@Entity
@Data
@Table(uniqueConstraints = { @UniqueConstraint(name = "UniqueNameAndSkillGroup",
        columnNames = { "name", "skillGroupId" }) })
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;
    private String name;
    private Instant creationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creationUserId")
    private User creationUser;
    @ManyToOne
    @JoinColumn(name = "skillGroupId")
    private SkillGroup skillGroup;
    private Boolean isDefaultSkill;
    @Transient
    private Integer numberOfUsers;
    @Transient
    private Integer numberOfTickets;
    private Boolean active = true;

}
