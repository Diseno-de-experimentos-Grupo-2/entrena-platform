package com.entrena.entrenaplatform.IAM.interfaces.rest.transform;

import com.entrena.entrenaplatform.IAM.domain.model.aggregates.User;
import com.entrena.entrenaplatform.IAM.domain.model.entities.Role;
import com.entrena.entrenaplatform.IAM.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        var roles = user.getRoles().stream().map(role -> role.getName().name()).toList();
        return new UserResource(user.getId(), user.getUsername(), roles);
    }
}
