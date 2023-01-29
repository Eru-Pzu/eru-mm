package com.hexagonalmultimodule.decisionservices.rest;

import com.hexagonalmultimodule.decisionapi.DecisionService;
import com.hexagonalmultimodule.decisionservices.DefaultDecisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/decision")
public class DecisionController implements DecisionService {
    private final DefaultDecisionService defaultDecisionService;

    @Override
    @PostMapping("/{customerId}")
    public Long createFrom(@PathVariable String customerId) {
        return defaultDecisionService.createFrom(customerId);
    }
}
