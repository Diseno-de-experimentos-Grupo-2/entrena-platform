package com.entrena.entrenaplatform.trainning.interfaces.rest.resources;

public record CreateRoutineResource(String title, String description, Long clientId) {
    public CreateRoutineResource {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Routine title cannot be empty");
        }
        if (clientId == null || clientId <= 0) {
            throw new IllegalArgumentException("Client ID must be positive");
        }
    }
}
