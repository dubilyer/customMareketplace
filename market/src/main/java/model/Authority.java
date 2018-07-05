package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import validators.UserRole;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
//TODO authorities to roles
@Entity
@Table(name = "roles")
@NamedQuery(name = "GET_AUTHORITY_BY_NAME", query = "FROM Authority WHERE role = :role")
@Data
@RequiredArgsConstructor @AllArgsConstructor
@Builder
public class Authority implements GrantedAuthority {

    public enum Role {
        ADMIN, USER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    long id;

    @NotNull
    @UserRole
    @Column(name = "role", unique = true)
    @Builder.Default String role = "USER";

    @Override
    public String getAuthority() {
        return role;
    }
}
