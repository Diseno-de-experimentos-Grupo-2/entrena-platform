package com.entrena.entrenaplatform.IAM.interfaces.rest.transform;

import com.entrena.entrenaplatform.IAM.domain.model.commands.SignUpCommand;
import com.entrena.entrenaplatform.IAM.domain.model.entities.Role;
import com.entrena.entrenaplatform.IAM.interfaces.rest.resources.SignUpResource;

import java.util.ArrayList;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        var roles = resource.roles() != null ? resource.roles().stream().map(name -> Role.toRoleFromName(name)).toList() : new ArrayList<Role>();
        return new SignUpCommand(resource.username(), resource.password(), roles);
    }
}
