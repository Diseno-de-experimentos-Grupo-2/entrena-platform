package com.entrena.entrenaplatform.trainning.domain.model.commands;

public record UpdateRoutineItemCommand(Long routineId, Long routineItemId, Integer sets, Integer reps, Integer restTimeSeconds) {
    public UpdateRoutineItemCommand {
        if (routineId == null || routineId <= 0) {
            throw new IllegalArgumentException("Routine ID must be positive");
        }
        if (routineItemId == null || routineItemId <= 0) {
            throw new IllegalArgumentException("Routine item ID must be positive");
        }
        if (sets != null && sets <= 0) {
            throw new IllegalArgumentException("Sets must be positive");
        }
        if (reps != null && reps <= 0) {
            throw new IllegalArgumentException("Reps must be positive");
        }
        if (restTimeSeconds != null && restTimeSeconds < 0) {
            throw new IllegalArgumentException("Rest time cannot be negative");
        }
    }
}
