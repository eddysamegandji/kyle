package com.kylemanagement.model;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.Data;

@Entity
@Table(name = "usergroup")
@Data
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userGroupId;
    private String name;
    private String siteName;
    private Instant creationDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creationUserId")
    private User creationUserId;
    private Instant deleteDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deleteUserId")
    private User deleteUserId;
    @Transient
    private Integer numberOfUsers;
    @Transient
    private Integer nbOpenedTickets;
    @Transient
    private Integer nbTickets;
}
