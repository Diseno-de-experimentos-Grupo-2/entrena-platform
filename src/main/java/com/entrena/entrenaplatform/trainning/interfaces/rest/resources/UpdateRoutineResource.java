package com.entrena.entrenaplatform.trainning.interfaces.rest.resources;

public record UpdateRoutineResource(String title, String description) {

    public UpdateRoutineResource {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Routine title cannot be empty");
        }
    }
}
