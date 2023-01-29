package com.hexagonalmultimodule.pricedomain.command;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Price implements Invalidateable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long price;
    private Boolean valid;

    @Override
    public Price invalidate() {
        this.valid = false;
        return this;
    }
}
