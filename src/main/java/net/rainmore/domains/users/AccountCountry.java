package net.rainmore.domains.users;

import net.rainmore.domains.Model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "accountmulticountry")
public class AccountCountry implements Model {

    private AccountCountryPK id;
    private Boolean primary = false;


    @EmbeddedId
    public AccountCountryPK getId() {
        return id;
    }

    public AccountCountry setId(AccountCountryPK id) {
        this.id = id;
        return this;
    }

    @Column(name = "isPrimary", nullable = false)
    @NotNull
    public Boolean isPrimary() {
        return primary;
    }

    public AccountCountry setPrimary(Boolean flag) {
        primary = flag;
        return this;
    }
}
