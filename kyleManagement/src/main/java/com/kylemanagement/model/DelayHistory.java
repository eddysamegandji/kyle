package com.kylemanagement.model;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.Data;

@Entity
@Table(name = "delayHistory")
@Data
public class DelayHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long delayHistoryId;
    private Instant delayDate;
    private String delayComment;
}
