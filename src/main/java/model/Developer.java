package model;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "developers")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column (name = "first_name")
    private String firstName;
    @Column (name = "last_name")
    private  String lastName;
    @Column (name = "specialty")
    private String specialty;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "developer_skill", joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Skill> skills;

    @JoinColumn(name = "account_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    public Developer(){}
    public Developer( String firstName, String lastName, String specialty, Set<Skill> skills, Account account) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.skills = skills;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
