package com.example.apiPharmacy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;

//////>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ADD  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<</////
@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinTable(
        name = "users_drugs",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "drug_id"))
    private final Set<Drug> drugs = new HashSet<>();
//////>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ADD  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<</////

    /**
     * Constructors
     */

    public Users() {

    }

    public Users(String userName) {
        this.userName = userName;
    }

    /**
     * Getters & Setters
     */

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//////>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ADD  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<</////
    public Set<Drug> getDrugs() {
        return drugs;
    }
//////>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ADD  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<</////

}
