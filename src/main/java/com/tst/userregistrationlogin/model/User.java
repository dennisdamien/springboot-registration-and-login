package com.tst.userregistrationlogin.model;

import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tblUser",uniqueConstraints = @UniqueConstraint(columnNames = "email"))

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

    @Column(name = "first_name")
     private String firstName;

    @Column(name = "last_name")
     private String lastName;

    @Column(name = "email")
     private String email;

     private String password;

     @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
     @JoinTable(
             name = "users_roles",
             joinColumns = @JoinColumn(
                     name="user_id",referencedColumnName = "id"
             ))
     private Collection<Role> roles;

    public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}