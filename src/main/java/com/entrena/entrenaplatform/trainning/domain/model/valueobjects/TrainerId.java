package com.entrena.entrenaplatform.trainning.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record TrainerId(Long trainerId) {

    //TODO: add validations
}
