package com.entrena.entrenaplatform.trainning.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record RestTime(Integer seconds) {

    public RestTime {
        if (seconds == null || seconds < 0) {
            throw new IllegalArgumentException("Rest time cannot be negative");
        }
    }
}
