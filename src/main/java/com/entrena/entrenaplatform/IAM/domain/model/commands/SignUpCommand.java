package com.entrena.entrenaplatform.IAM.domain.model.commands;

import com.entrena.entrenaplatform.IAM.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String password, List<Role> roles) {
}
