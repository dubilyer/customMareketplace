package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "users",
        uniqueConstraints = @UniqueConstraint(name = "username_user_uc", columnNames = "username"))
@NamedQueries({
    @NamedQuery(name = "GET_USER_BY_USERNAME", query = "FROM User WHERE username = :username"),
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    long id;

    @Email
    @NotNull
    @Column(name = "username", unique = true)
    String username;

    @Column(name = "password")
    String password;

    public User(@Email @NotNull String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(() -> "ADMIN");
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
