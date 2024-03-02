package com.kylemanagement.model;

import com.kylemanagement.enums.ticket.TicketPriorityEnum;
import com.kylemanagement.enums.ticket.TicketStatusEnum;
import jakarta.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Data;

@Entity(name = "ticket")
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;
    private Instant creationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creationUserId")
    private User creationUser;
    private String creationSummary;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigneeUserId")
    private User assigneeUser;
    private Instant closingDate;
    @Column(name = "statusId")
    @Enumerated(EnumType.STRING)
    private TicketStatusEnum status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typologyId")
    private TicketTypology typology;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "initialSkillId")
    private Skill initialSkill;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currentSkillId")
    private Skill currentSkill;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userGroupId")
    private UserGroup userGroup;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;
    private Instant lastModifiedDate;
    private Instant startDate;
    private Instant endDate;
//    @OneToMany
//    @JoinTable(name = "delayHistoryTicket", joinColumns = {
//            @JoinColumn(name = "ticketId")}, inverseJoinColumns = {@JoinColumn(name = "delayHistoryId")})
//    private List<DelayHistory> delayHistory;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modifiedUserId")
    private User modifiedUser;
    private String lastTicketActionComment;
    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private TicketPriorityEnum priority;
    private Integer flagId;
    @OneToMany(targetEntity = Document.class, fetch = FetchType.LAZY)
    @JoinTable(name = "documentRelation", joinColumns = {
            @JoinColumn(name = "ticketId")}, inverseJoinColumns = {@JoinColumn(name = "documentId")})
    private Set<Document> documents = new HashSet<>();

}
