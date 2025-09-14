package com.entrena.entrenaplatform.trainning.interfaces.rest.transform;

import com.entrena.entrenaplatform.trainning.domain.model.entities.RoutineItem;
import com.entrena.entrenaplatform.trainning.interfaces.rest.resources.RoutineItemResource;

public class RoutineItemResourceFromEntityAssembler {


    public static RoutineItemResource toResourceFromEntity(RoutineItem entity) {
        return new RoutineItemResource(
                entity.getId(),
                entity.getExerciseId().exerciseId(),
                entity.getSets().value(),
                entity.getReps().value(),
                entity.getRestTime().seconds(),
                entity.getOrderIndex()
        );
    }
}
