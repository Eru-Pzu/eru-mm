package com.hexagonalmultimodule.pricedomain.command;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DbPriceRepository extends JpaRepository<Price, Long> {
}
