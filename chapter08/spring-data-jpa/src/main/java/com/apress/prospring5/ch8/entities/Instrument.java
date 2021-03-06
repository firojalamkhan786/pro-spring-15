package com.apress.prospring5.ch8.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "instrument")
@NoArgsConstructor
public class Instrument implements Serializable {
    @Id
    @Column(name = "INSTRUMENT_ID")
    @Getter @Setter private String instrumentId;

    @ManyToMany
    @JoinTable(name = "singer_instrument",
            joinColumns = @JoinColumn(name = "INSTRUMENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "SINGER_ID"))
    @Getter @Setter private Set<Singer> singers = new HashSet<>();

    @Override
    public String toString() {
        return "Instrument :" + getInstrumentId();
    }
}