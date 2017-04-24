package net.rainmore.domains.users;

import net.rainmore.domains.locations.Area;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class AccountAreaPK implements Serializable {

    private Account account;
    private Area location;

    public AccountAreaPK() {
    }

    public AccountAreaPK(Account account, Area location) {
        this.account = account;
        this.location = location;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userAccountId", nullable = false, updatable = false)
    @NotNull
    public Account getAccount() {
        return account;
    }

    public AccountAreaPK setAccount(Account account) {
        this.account = account;
        return this;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "areaID", nullable = false, updatable = false)
    @NotNull
    public Area getLocation() {
        return location;
    }

    public AccountAreaPK setLocation(Area location) {
        this.location = location;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountAreaPK)) return false;

        AccountAreaPK that = (AccountAreaPK) o;

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
