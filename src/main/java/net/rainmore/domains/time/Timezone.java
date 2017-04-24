package net.rainmore.domains.time;

import net.rainmore.domains.Model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.TimeZone;

@Entity
@Table(name = "timezones")
public class Timezone implements Model {

    private Long id;
    private String name;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public Timezone setId(Long id) {
        this.id = id;
        return this;
    }

    @Column
    @Size(max = 64)
    public String getName() {
        return name;
    }

    public Timezone setName(String name) {
        this.name = name;
        return this;
    }

    @Transient
    public TimeZone getTimeZone() {
        return TimeZone.getTimeZone(getName());
    }
}
