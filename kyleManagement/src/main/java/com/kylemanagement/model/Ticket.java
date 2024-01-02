package com.kylemanagement.model;

import com.kylemanagement.enums.ticket.TicketStatusEnum;
import com.kylemanagement.enums.ticket.TicketTypeEnum;
import jakarta.persistence.*;
import java.time.Instant;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creationUserId", referencedColumnName = "userId")
    private User creationUser;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Instant creationDate;
    private Instant lastModificationDate;
    private Instant closingDate;
    private Instant initialDelayDate;
    private Instant newDelayDate;
    @Enumerated(EnumType.STRING)
    private TicketTypeEnum ticketType;
    @Enumerated(EnumType.STRING)
    private TicketStatusEnum ticketStatus;
    private String creationSummary;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigneeUserId", referencedColumnName = "userId")
    private User assigneeUser;

    private Instant assignDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skillId", referencedColumnName = "skillId")
    private Skill skill;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usergroupId", referencedColumnName = "usergroupId")
    private UserGroup userGroup;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;

}
