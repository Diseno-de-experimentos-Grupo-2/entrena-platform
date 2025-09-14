package com.entrena.entrenaplatform.trainning.interfaces.rest.resources;

public record AddExerciseToRoutineResource(Long exerciseId, Integer sets, Integer reps, Integer restTimeSeconds, Integer orderIndex) {

    public AddExerciseToRoutineResource {
        if (exerciseId == null || exerciseId <= 0) {
            throw new IllegalArgumentException("Exercise ID must be positive");
        }
        if (sets == null || sets <= 0) {
            throw new IllegalArgumentException("Sets must be positive");
        }
        if (reps == null || reps <= 0) {
            throw new IllegalArgumentException("Reps must be positive");
        }
        if (restTimeSeconds == null || restTimeSeconds < 0) {
            throw new IllegalArgumentException("Rest time cannot be negative");
        }
        if (orderIndex == null || orderIndex < 0) {
            throw new IllegalArgumentException("Order index cannot be negative");
        }
    }

}
