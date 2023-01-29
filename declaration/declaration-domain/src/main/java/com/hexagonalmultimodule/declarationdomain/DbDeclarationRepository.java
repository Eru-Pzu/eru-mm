package com.hexagonalmultimodule.declarationdomain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DbDeclarationRepository extends JpaRepository<Declaration, Long> {
    List<Declaration> findAllByProductIdIn(List<Long> productIds);

    void deleteAllByProductIdIn(List<Long> productIds);
}
