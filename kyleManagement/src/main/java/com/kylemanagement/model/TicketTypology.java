package com.kylemanagement.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.Calendar;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "tickettypology")
@Data
public class TicketTypology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketTypologyId;
    @NaturalId
    private String name;
    private Boolean active;
    @ManyToOne
    @JoinColumn(name = "skillId")
    private Skill skill;
    private Instant creationDate;
    @ManyToOne
    @JoinColumn(name = "creationUserId")
    private User creationUserId;
    private Instant deleteDate;
    @ManyToOne
    @JoinColumn(name = "deleteUserId")
    private User deleteUserId;

}
