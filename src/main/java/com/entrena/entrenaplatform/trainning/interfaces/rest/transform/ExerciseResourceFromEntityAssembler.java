package com.entrena.entrenaplatform.trainning.interfaces.rest.transform;

import com.entrena.entrenaplatform.trainning.domain.model.aggregates.Exercise;
import com.entrena.entrenaplatform.trainning.interfaces.rest.resources.ExerciseResource;

public class ExerciseResourceFromEntityAssembler {

    public static ExerciseResource toResourceFromEntity(Exercise entity){
        return new ExerciseResource(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getMuscleGroup()
        );
    }
}
