package com.iranargham.atmmonitoring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Builder(toBuilder=true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "oauth_users_roles")
public class UserRole implements Serializable {

    @Id
    @SequenceGenerator(name = "oauth_users_roles_id_seq", sequenceName = "oauth_users_roles_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oauth_users_roles_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "userid")
    private Long userId;

    @Column(name = "role", columnDefinition = "nvarchar2(255)")
    private String role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(id, userRole.id) ;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "user=" + userId +
                ", role='" + role + '\'' +
                '}';
    }
}
