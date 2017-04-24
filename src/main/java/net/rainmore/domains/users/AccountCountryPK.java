package net.rainmore.domains.users;

import net.rainmore.domains.locations.Country;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class AccountCountryPK implements Serializable {

    private Account account;
    private Country location;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userAccountId", nullable = false, updatable = false)
    @NotNull
    public Account getAccount() {
        return account;
    }

    public AccountCountryPK setAccount(Account account) {
        this.account = account;
        return this;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "countryID", nullable = false, updatable = false)
    @NotNull
    public Country getLocation() {
        return location;
    }

    public AccountCountryPK setLocation(Country location) {
        this.location = location;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountCountryPK)) return false;

        AccountCountryPK that = (AccountCountryPK) o;

        if (!getAccount().equals(that.getAccount())) return false;
        return getLocation().equals(that.getLocation());
    }

    @Override
    public int hashCode() {
        int result = getAccount().hashCode();
        result = 31 * result + getLocation().hashCode();
        return result;
    }
}
