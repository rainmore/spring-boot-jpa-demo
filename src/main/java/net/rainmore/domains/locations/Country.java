package net.rainmore.domains.locations;

import net.rainmore.domains.Model;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country implements Model {

    private Long id;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public Country setId(Long id) {
        this.id = id;
        return this;
    }
}
