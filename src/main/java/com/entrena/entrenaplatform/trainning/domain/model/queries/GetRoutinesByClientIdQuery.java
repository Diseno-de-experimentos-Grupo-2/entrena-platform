package com.entrena.entrenaplatform.trainning.domain.model.queries;

public record GetRoutinesByClientIdQuery(Long clientId) {

    public GetRoutinesByClientIdQuery {
        if (clientId == null || clientId <= 0) {
            throw new IllegalArgumentException("Client ID must be positive");
        }
    }
}
