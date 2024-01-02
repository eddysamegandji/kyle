package com.kylemanagement.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Data
@Table(name = "userskillrelation")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class UserSkillRelation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name="userId", referencedColumnName="userId")
	@JsonBackReference
	private User user;

	@Id
	@ManyToOne
	@JoinColumn(name="skillId", referencedColumnName="skillId")
	private Skill skill;

}
