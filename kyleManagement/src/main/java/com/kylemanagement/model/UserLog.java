package com.kylemanagement.model;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.*;

@Entity
@Data
public class UserLog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userLogId;
  @ManyToOne
  @JoinColumn(name = "userId")
  private User user;
  private String serviceName;
  @Column(columnDefinition="TEXT")
  private String params;
  private String logMessage;
  private Instant date;
}
