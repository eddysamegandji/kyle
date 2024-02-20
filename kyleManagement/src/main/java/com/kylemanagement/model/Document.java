package com.kylemanagement.model;

import com.kylemanagement.enums.document.DocumentDispositionTypeEnum;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "document")
@BatchSize(size = 1000)
@Data
public class Document implements Cloneable, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;
    private String fileName;
    private Long fileSize;
    private String storagePath;
    private String storageName;
    private DocumentDispositionTypeEnum disposition;
    private String contentId;
    private String contentType;
    private String externalUrl;
    private String token;
    private Calendar creationDate;
    private Calendar updateDate;
    private Calendar deleteDate;
    private Integer creationUserId;
    private Integer updateUserId;
    private Integer deleteUserId;
    private Boolean isAdministrable = false;
    private boolean isArchived;
}
