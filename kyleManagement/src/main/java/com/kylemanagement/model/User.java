package com.kylemanagement.model;

import jakarta.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import lombok.Data;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String login;
    private String lastName;
    private String firstName;
    @Formula(value = "concat(coalesce(last_name, ''), ' ', coalesce(first_name, ''))")
    private String userFullName;
    private String password;
    private Instant passwordLastChangedDate;
    private String email;
    private String phone;
    private String rights;
    private String locale;
    private Instant firstConnectionDate;
    private Instant lastConnectionDate;
    private Instant creationDate;
    private Integer creationUserId;
    private Instant deleteDate;
    private Integer deleteUserId;
    private boolean active = true;
    @OneToMany
    @JoinTable(name = "UserGroupRelation", joinColumns = {
            @JoinColumn(name = "userId")}, inverseJoinColumns = {@JoinColumn(name = "userGroupId")})
    private List<UserGroup> groups = new ArrayList<>();
    @OneToMany
    @JoinTable(name = "UserSkillRelation", joinColumns = {
            @JoinColumn(name = "userId")}, inverseJoinColumns = {@JoinColumn(name = "skillId")})
    private List<Skill> skills = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(List.of(rights));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
