package com.kylemanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import lombok.Data;

@Entity
@Data
@Table(name = "usergrouprelation")
public class UserGroupRelation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name="userId", referencedColumnName="userId")
	@JsonBackReference
	private User user;

	@Id
	@ManyToOne
	@JoinColumn(name="usergroupId", referencedColumnName="usergroupId")
	private UserGroup userGroup;
}
