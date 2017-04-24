package net.rainmore.domains.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.rainmore.domains.Model;
import net.rainmore.domains.locations.Area;
import net.rainmore.domains.locations.Country;
import net.rainmore.domains.time.Timezone;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "userAccounts")
public class Account implements Model {

    private Long id;

    private Timezone timezone;

    private List<AccountCountry> accountCountries = new ArrayList<>();
    private List<AccountArea>    accountAreas     = new ArrayList<>();


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public Account setId(Long id) {
        this.id = id;
        return this;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id.account"/*, cascade = { CascadeType.PERSIST, CascadeType.REMOVE }*/, orphanRemoval = true)
    public List<AccountCountry> getAccountCountries() {
        return accountCountries;
    }

    public Account setAccountCountries(List<AccountCountry> accountCountries) {
        this.accountCountries = accountCountries;
        return this;
    }

    @Transient
    @JsonIgnore
    public Country getPrimaryCountry() {
        return getAccountCountries().stream()
                .filter(AccountCountry::isPrimary).map(relation -> relation.getId().getLocation()).findFirst().orElse(null);
    }

    public Account resetAccountCountries() {
        getAccountCountries().clear();
        return this;
    }

    public Account addAccountCountry(AccountCountry accountCountry) {
        getAccountCountries().add(accountCountry);
        return this;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id.account"/*, cascade = { CascadeType.PERSIST, CascadeType.REMOVE }*/, orphanRemoval = true)
    public List<AccountArea> getAccountAreas() {
        return accountAreas;
    }

    public Account setAccountAreas(List<AccountArea> accountAreas) {
        this.accountAreas = accountAreas;
        return this;
    }

    public Account resetAccountAreas() {
        getAccountAreas().clear();
        return this;
    }

    public Account addAccountArea(AccountArea accountArea) {
        getAccountAreas().add(accountArea);
        return this;
    }

    @Transient
    @JsonIgnore
    public Area getPrimaryArea() {
        return getAccountAreas().stream()
                .filter(AccountArea::isPrimary).map(relation -> relation.getId().getLocation()).findFirst().orElse(null);
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "timezoneId", nullable = false)
    public Timezone getTimezone() {
        return timezone;
    }

    public Account setTimezone(Timezone timezone) {
        this.timezone = timezone;
        return this;
    }
}
