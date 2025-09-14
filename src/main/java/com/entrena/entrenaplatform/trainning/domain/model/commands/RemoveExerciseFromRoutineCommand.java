package com.entrena.entrenaplatform.trainning.domain.model.commands;

public record RemoveExerciseFromRoutineCommand(Long routineId, Long routineItemId) {

    public RemoveExerciseFromRoutineCommand {
        if (routineId == null || routineId <= 0) {
            throw new IllegalArgumentException("Routine ID must be positive");
        }
        if (routineItemId == null || routineItemId <= 0) {
            throw new IllegalArgumentException("Routine item ID must be positive");
        }
    }

}
