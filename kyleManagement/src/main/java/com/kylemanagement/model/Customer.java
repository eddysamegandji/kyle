package com.kylemanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.time.Instant;
import lombok.Data;
import org.hibernate.annotations.Formula;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @Size(max = 100)
    private String firstName;
    @Size(max = 100)
    private String lastName;
    @Formula(value = "concat(coalesce(first_name, ''), ' ', coalesce(last_name, ''))")
    private String fullName;
    @Size(max = 100)
    private String address1;
    @Size(max = 100)
    private String address2;
    @Size(max = 100)
    private String zipCode;
    @Size(max = 100)
    private String city;
    @Size(max = 100)
    private String country;
    @Size(max = 100)
    private String birthCity;
    @Size(max = 100)
    private String birthDepartment;
    @Size(max = 100)
    private String birthName;
    private Instant birthDate;
    @Size(max = 100)
    private String title;
    private String contactSearch; // updated by sql trigger
    @Size(max = 100)
    private String companyName;
    @Size(max = 100)
    private String companyPosition;
    @Size(max = 100)
    private String customerRef;
    @Size(max = 100)
    private String kbis;
    @Size(max = 40)
    private String fax;
    @Size(max = 40)
    private String homePhone;
    @Size(max = 40)
    private String mobilePhone;
    @Size(max = 40)
    private String workPhone;
    @Size(max = 40)
    private String otherPhone;
    @Size(max = 256)
    private String emailAddress;
    @Size(max = 256)
    private String emailAddress2;
    @Size(max = 256)
    private String emailName;
    private String comments;
    private Instant creationDate;
    private Long creationUserId;
    private Instant lastModifiedDate;
    private Long updateUserId;
    private Instant deleteDate;
    private Long deleteUserId;
    private Boolean vip;

}
