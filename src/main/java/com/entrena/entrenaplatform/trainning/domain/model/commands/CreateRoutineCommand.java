package com.entrena.entrenaplatform.trainning.domain.model.commands;

public record CreateRoutineCommand(String title, String description, Long clientId) {

    public CreateRoutineCommand {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Routine title cannot be empty");
        }
        if (clientId == null || clientId <= 0) {
            throw new IllegalArgumentException("Client ID must be positive");
        }
    }
}
