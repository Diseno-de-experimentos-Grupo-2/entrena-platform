package com.entrena.entrenaplatform.trainning.interfaces.rest.transform;

import com.entrena.entrenaplatform.trainning.domain.model.commands.CreateExerciseCommand;
import com.entrena.entrenaplatform.trainning.interfaces.rest.resources.CreateExerciseResource;

public class CreateExerciseCommandFromResourceAssembler {

    public static CreateExerciseCommand toCommandFromResource(CreateExerciseResource resource){
        return new CreateExerciseCommand(
                resource.name(),
                resource.description(),
                resource.muscleGroup()
        );
    }

}
