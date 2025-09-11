package com.entrena.entrenaplatform.trainning.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Reps(Integer value) {

    public Reps {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("Reps must be positive");
        }
    }


}
