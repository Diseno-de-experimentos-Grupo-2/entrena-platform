package com.entrena.entrenaplatform.trainning.interfaces.rest.resources;

public record UpdateExerciseResource(String name, String description, String muscleGroup) {

    public UpdateExerciseResource {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Exercise name cannot be empty");
        }
        if (muscleGroup == null || muscleGroup.trim().isEmpty()) {
            throw new IllegalArgumentException("Muscle group cannot be empty");
        }
    }
}
