package com.entrena.entrenaplatform.IAM.domain.services;

import com.entrena.entrenaplatform.IAM.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
