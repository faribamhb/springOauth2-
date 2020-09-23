package com.iranargham.atmmonitoring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "oauth_users")
public class OauthUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @Id
    @SequenceGenerator(name = "oauth_users_id_seq", sequenceName = "oauth_users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oauth_users_id_seq")
    @Column(name = "id")
    private Long userId;

    @Column(name = "username")
    @NotNull
    private String userName;

    @Column(name = "password" , columnDefinition = "nvarchar2(255)")
    @NotNull
    private String password;

    @JsonIgnore
    @Column(name = "enabled")
    private boolean enabled = true;

    @JsonIgnore
    @Column(name = "creation_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate = new Date();


    public OauthUser(Optional<OauthUser> user) {
    }

    public OauthUser() {
    }

    public OauthUser(OauthUser oauthUser) {
        this.userId = oauthUser.userId;
        this.userName = oauthUser.userName;
        this.password = oauthUser.password;
        this.enabled = oauthUser.enabled;
    }

    public Long getUserId() {
        return userId;
    }

    public OauthUser setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public OauthUser setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public OauthUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public OauthUser setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public OauthUser setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
        return this;
    }
}