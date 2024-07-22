package com.example.cpuspikesimulator.services;

import org.springframework.stereotype.Service;

@Service
public class IntermediateService {

    private final HeavyComputationService heavyComputationService;

    public IntermediateService(HeavyComputationService heavyComputationService) {
        this.heavyComputationService = heavyComputationService;
    }

    public void executeIntermediateTask() {
        for (int i = 0; i < 1000; i++) {
            heavyComputationService.performHeavyComputation();
        }
    }
}
