package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users",
        uniqueConstraints = @UniqueConstraint(name = "username_user_uc", columnNames = "username"))
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    long id;

    @Email
    @NotNull
    @Column(name = "username", unique = true)
    String username;

    public User(@Email @NotNull String username) {
        this.username = username;
    }
}
