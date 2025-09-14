package com.entrena.entrenaplatform.trainning.domain.model.queries;

public record GetRoutineByIdQuery(Long routineId) {
    public GetRoutineByIdQuery {
        if (routineId == null || routineId <= 0) {
            throw new IllegalArgumentException("Routine ID must be positive");
        }
    }
}
