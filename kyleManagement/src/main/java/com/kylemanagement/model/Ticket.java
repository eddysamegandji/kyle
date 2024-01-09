package com.kylemanagement.model;

import com.kylemanagement.enums.ticket.TicketStatusEnum;
import jakarta.persistence.*;
import java.time.Instant;
import lombok.Data;

@Entity
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;
    private Instant creationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creationUserId", referencedColumnName = "userId")
    private User creationUser;
    private String creationSummary;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigneeUserId")
    private User assigneeUser;
    private Instant closingDate;
    @Column(name = "ticketStatusId")
    @Enumerated(EnumType.STRING)
    private TicketStatusEnum ticketStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticketTypologyId")
    private TicketTypology ticketTypology;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "initialSkillId")
    private Skill initialSkill;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currentSkillId")
    private Skill currentSkill;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticketUserGroupId")
    private UserGroup ticketUserGroup;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;
    private Instant lastModifiedDate;
    private Instant initialDueDate;
    private Instant secondDueDate;
    private Instant thirdDueDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modifiedUserId")
    private User modifiedUserId;



}
