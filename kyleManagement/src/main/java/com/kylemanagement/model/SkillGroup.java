package com.kylemanagement.model;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Getter
public class SkillGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillGroupId;
    @Column(unique = true)
    private String name;
    private Boolean active = true;
    private Instant creationDate;
    @ManyToOne
    @JoinColumn(name = "creationUserId")
    private User creationUser;
    @ManyToOne
    @JoinColumn(name = "lastModifiedUserId")
    private User lastModifiedUser;
    private Instant lastModifiedDate;
}
