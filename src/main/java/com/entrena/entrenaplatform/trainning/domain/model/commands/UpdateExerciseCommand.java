package com.entrena.entrenaplatform.trainning.domain.model.commands;

public record UpdateExerciseCommand(Long exerciseId, String name, String description, String muscleGroup) {


    public UpdateExerciseCommand {
        if (exerciseId == null || exerciseId <= 0) {
            throw new IllegalArgumentException("Exercise ID must be positive");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Exercise name cannot be empty");
        }
    }


}
