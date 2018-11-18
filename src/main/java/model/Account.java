package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNTS")
public class Account {

    private Long id;
    private String accountData;

    public Account() {
    }

    public Account(String accountData) {
        this.accountData = accountData;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ACCOUNTDATA")
    public String getAccountData() {
        return accountData;
    }

    public void setAccountData(String accountData) {
        this.accountData = accountData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(getId(), account.getId()) &&
                Objects.equals(getAccountData(), account.getAccountData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccountData());
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountData='" + accountData + '\'' +
                '}';
    }
}
