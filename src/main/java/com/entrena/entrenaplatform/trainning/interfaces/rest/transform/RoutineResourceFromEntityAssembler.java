package com.entrena.entrenaplatform.trainning.interfaces.rest.transform;

import com.entrena.entrenaplatform.trainning.domain.model.aggregates.Routine;
import com.entrena.entrenaplatform.trainning.interfaces.rest.resources.RoutineResource;

import java.util.stream.Collectors;

public class RoutineResourceFromEntityAssembler {

    public static RoutineResource toResourceFromEntity(Routine entity) {
        var exerciseResources = entity.getExercises().stream()
                .map(RoutineItemResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());

        return new RoutineResource(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getClientId().clientId(),
                exerciseResources
        );
    }
}
