package com.entrena.entrenaplatform.IAM.domain.services;

import com.entrena.entrenaplatform.IAM.domain.model.aggregates.User;
import com.entrena.entrenaplatform.IAM.domain.model.commands.SignInCommand;
import com.entrena.entrenaplatform.IAM.domain.model.commands.SignUpCommand;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Optional;

public interface UserCommandService {
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);

    /**
     * Handle sign up command
     * @param command the {@link SignUpCommand} command
     * @return an {@link Optional} of {@link User} entity
     */
    Optional<User> handle(SignUpCommand command);


}
