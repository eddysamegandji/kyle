package com.kylemanagement.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "usergrouprelation")
@Data
public class UserGroupRelation {

    @Id
    @ManyToOne
    @JoinColumn(name="userId", referencedColumnName="userId")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name="userGroupId", referencedColumnName="userGroupId")
    private UserGroup userGroup;

}
