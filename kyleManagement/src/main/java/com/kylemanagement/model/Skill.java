package com.kylemanagement.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.Calendar;
import lombok.Data;

@Entity
@Data
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;
    private String name;
    private Instant creationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creationUserId")
    private User creationUser;
    @Transient
    private Integer numberOfUsers;
    @Transient
    private Integer numberOfTickets;
    private boolean active = true;


}
