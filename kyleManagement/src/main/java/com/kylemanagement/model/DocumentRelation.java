package com.kylemanagement.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "documentRelation")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "documentRelationId", updatable = false, nullable = false)
    private Long documentRelationid;
    private Long documentId;
    private Long ticketId;
    private Long customerId;
}
