package com.example.cpuspikesimulator.tasks;

import com.example.cpuspikesimulator.services.IntermediateService;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class CpuSpikeTask {

    private final IntermediateService intermediateService;

    public CpuSpikeTask(IntermediateService intermediateService) {
        this.intermediateService = intermediateService;
    }

    public void simulateCpuSpike(long duration, int threads) {
        ExecutorService executorService = Executors.newFixedThreadPool(threads);

        for (int i = 0; i < threads; i++) {
            executorService.submit(() -> {
                long startTime = System.currentTimeMillis();
                while (System.currentTimeMillis() - startTime < duration) {
                    intermediateService.executeIntermediateTask();
                }
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(duration + 1000, java.util.concurrent.TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
