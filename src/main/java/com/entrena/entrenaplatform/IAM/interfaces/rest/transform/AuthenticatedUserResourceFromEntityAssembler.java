package com.entrena.entrenaplatform.IAM.interfaces.rest.transform;

import com.entrena.entrenaplatform.IAM.domain.model.aggregates.User;
import com.entrena.entrenaplatform.IAM.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
    }
}
