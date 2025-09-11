package com.entrena.entrenaplatform.trainning.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ExerciseId(Long exerciseId) {

    public ExerciseId {
        if (exerciseId == null || exerciseId <= 0) {
            throw new IllegalArgumentException("Exercise ID must be positive");
        }
    }
}
