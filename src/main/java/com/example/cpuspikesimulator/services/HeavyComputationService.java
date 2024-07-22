package com.example.cpuspikesimulator.services;

import org.springframework.stereotype.Service;

@Service
public class HeavyComputationService {

    public void performHeavyComputation() {
        double result = Math.pow(Math.random(), Math.random());
    }
}
