package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users",
        uniqueConstraints = @UniqueConstraint(name = "email_user_uc", columnNames = "email"))
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
    @Column(name = "email", unique = true)
    String email;

    public User(@Email @NotNull String email) {
        this.email = email;
    }
}
