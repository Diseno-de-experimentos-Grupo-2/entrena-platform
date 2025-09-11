package com.entrena.entrenaplatform.trainning.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Sets(Integer value) {

    public Sets {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("Sets must be positive");
        }

    }
}
