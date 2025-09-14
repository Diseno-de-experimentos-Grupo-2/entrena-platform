package com.entrena.entrenaplatform.trainning.interfaces.rest.transform;

import com.entrena.entrenaplatform.trainning.domain.model.commands.CreateRoutineCommand;
import com.entrena.entrenaplatform.trainning.interfaces.rest.resources.CreateRoutineResource;

public class CreateRoutineCommandFromResourceAssembler {


    public static CreateRoutineCommand toCommandFromResource(CreateRoutineResource resource) {
        return new CreateRoutineCommand(
                resource.title(),
                resource.description(),
                resource.clientId()
        );
    }
}
