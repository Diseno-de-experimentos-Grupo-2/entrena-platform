package com.entrena.entrenaplatform.trainning.domain.model.commands;

public record UpdateRoutineCommand(Long routineId, String title, String description) {

    public UpdateRoutineCommand {
        if (routineId == null || routineId <= 0) {
            throw new IllegalArgumentException("Routine ID must be positive");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Routine title cannot be empty");
        }
    }
}
