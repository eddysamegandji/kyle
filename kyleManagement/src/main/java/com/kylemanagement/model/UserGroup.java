package com.kylemanagement.model;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Data
@Table(name="usergroup")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class UserGroup implements Cloneable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usergroupId;
	private String name;
	private String description;
	private String siteName;
	private Integer displayOrder;
	private Instant creationDate;
	private Integer creationUserId;
	private Instant deleteDate;
	private Integer deleteUserId;
	private Integer numberOfUsers;
	private boolean isAvailableOnTicketCreation = true;
	private boolean isAvailableOnTicketTreatment = true;
    private int nbTickets;
}
