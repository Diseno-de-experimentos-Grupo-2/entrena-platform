package com.entrena.entrenaplatform.profiles.domain.services;

import com.entrena.entrenaplatform.profiles.domain.model.aggregates.Profile;
import com.entrena.entrenaplatform.profiles.domain.model.commands.CreateProfileCommand;

import java.util.Optional;

/**
 * Profile Command Service
 */
public interface ProfileCommandService {
    /**
     * Handle Create Profile Command
     *
     * @param command The {@link CreateProfileCommand} Command
     * @return A {@link Profile} instance if the command is valid, otherwise empty
     * @throws IllegalArgumentException if the email address already exists
     */
    Optional<Profile> handle(CreateProfileCommand command);
}
