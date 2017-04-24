package net.rainmore.domains.users;

import net.rainmore.domains.Model;
import net.rainmore.domains.locations.Area;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "accountmultiarea")
public class AccountArea implements Model {

    private AccountAreaPK id;
    private Boolean primary = false;

    public AccountArea() {
    }

    public AccountArea(AccountAreaPK id, Boolean primary) {
        this.id = id;
        this.primary = primary;
    }

    public AccountArea(Account account, Area area, Boolean primary) {
        this.id = new AccountAreaPK(account, area);
        this.primary = primary;
    }


    @EmbeddedId
    public AccountAreaPK getId() {
        return id;
    }

    public AccountArea setId(AccountAreaPK id) {
        this.id = id;
        return this;
    }

    @Column(name = "isPrimary", nullable = false)
    @NotNull
    public Boolean isPrimary() {
        return primary;
    }

    public AccountArea setPrimary(Boolean flag) {
        primary = flag;
        return this;
    }
}
