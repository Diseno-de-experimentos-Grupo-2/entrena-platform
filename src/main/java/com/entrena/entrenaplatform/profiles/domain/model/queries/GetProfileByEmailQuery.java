package com.entrena.entrenaplatform.profiles.domain.model.queries;

import com.entrena.entrenaplatform.profiles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}
