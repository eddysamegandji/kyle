package com.kylemanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "delayHistoryTicket")
@Data
public class DelayHistoryTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long delayHistoryTicketId;
    private Long ticketId;
    private Long delayHistoryId;
}
