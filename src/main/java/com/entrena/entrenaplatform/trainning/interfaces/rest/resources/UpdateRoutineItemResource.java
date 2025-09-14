package com.entrena.entrenaplatform.trainning.interfaces.rest.resources;

public record UpdateRoutineItemResource(Integer sets, Integer reps, Integer restTimeSeconds) {


    public UpdateRoutineItemResource {
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
