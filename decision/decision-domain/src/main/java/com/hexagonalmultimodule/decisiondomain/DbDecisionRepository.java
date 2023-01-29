package com.hexagonalmultimodule.decisiondomain;

import com.hexagonalmultimodule.decisiondomain.model.Decision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DbDecisionRepository extends JpaRepository<Decision, Long> {

}
