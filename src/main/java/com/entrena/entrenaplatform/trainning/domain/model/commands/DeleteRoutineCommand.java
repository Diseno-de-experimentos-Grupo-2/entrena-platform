package com.entrena.entrenaplatform.trainning.domain.model.commands;

public record DeleteRoutineCommand(Long routineId) {

    public DeleteRoutineCommand {
        if (routineId == null || routineId <= 0) {
            throw new IllegalArgumentException("Routine ID must be positive");
        }
    }

}
