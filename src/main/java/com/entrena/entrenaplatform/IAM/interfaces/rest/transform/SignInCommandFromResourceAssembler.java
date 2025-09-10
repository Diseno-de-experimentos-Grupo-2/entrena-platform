package com.entrena.entrenaplatform.IAM.interfaces.rest.transform;

import com.entrena.entrenaplatform.IAM.domain.model.commands.SignInCommand;
import com.entrena.entrenaplatform.IAM.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
}
