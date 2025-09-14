package com.entrena.entrenaplatform.trainning.interfaces.rest.transform;

import com.entrena.entrenaplatform.trainning.domain.model.commands.UpdateExerciseCommand;
import com.entrena.entrenaplatform.trainning.interfaces.rest.resources.UpdateExerciseResource;

public class UpdateExerciseCommandFromResourceAssembler {

    public static UpdateExerciseCommand toCommandFromResource(Long exerciseId, UpdateExerciseResource resource) {
        return new UpdateExerciseCommand(
                exerciseId,
                resource.name(),
                resource.description(),
                resource.muscleGroup()
        );
    }
}
