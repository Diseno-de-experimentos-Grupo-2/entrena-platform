package com.entrena.entrenaplatform.trainning.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ClientId(Long clientId) {

    //TODO: add validations
}
