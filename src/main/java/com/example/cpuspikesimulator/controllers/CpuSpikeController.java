package com.example.cpuspikesimulator.controllers;

import com.example.cpuspikesimulator.tasks.CpuSpikeTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CpuSpikeController {

    private final CpuSpikeTask cpuSpikeTask;

    public CpuSpikeController(CpuSpikeTask cpuSpikeTask) {
        this.cpuSpikeTask = cpuSpikeTask;
    }

    @GetMapping("/spike")
    public String triggerCpuSpike(@RequestParam long duration, @RequestParam int threads) {
        cpuSpikeTask.simulateCpuSpike(duration, threads);
        return "CPU spike for " + duration + " milliseconds with " + threads + " threads completed.";
    }
}
