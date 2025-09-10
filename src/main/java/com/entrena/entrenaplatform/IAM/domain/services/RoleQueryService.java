package com.entrena.entrenaplatform.IAM.domain.services;

import com.entrena.entrenaplatform.IAM.domain.model.entities.Role;
import com.entrena.entrenaplatform.IAM.domain.model.queries.GetAllRolesQuery;
import com.entrena.entrenaplatform.IAM.domain.model.queries.GetRoleByNameQuery;

import java.util.List;
import java.util.Optional;

public interface RoleQueryService {
    List<Role> handle(GetAllRolesQuery query);

    /**
     * Handle get role by name query
     * @param query the {@link GetRoleByNameQuery} query
     * @return an {@link Optional} of {@link Role} entity
     */
    Optional<Role> handle(GetRoleByNameQuery query);
}
