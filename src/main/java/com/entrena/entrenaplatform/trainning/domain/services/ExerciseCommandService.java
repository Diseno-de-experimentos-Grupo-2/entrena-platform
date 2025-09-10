package com.entrena.entrenaplatform.trainning.domain.services;

import com.entrena.entrenaplatform.trainning.domain.model.commands.AddExerciseToRoutineCommand;
import com.entrena.entrenaplatform.trainning.domain.model.commands.CreateExerciseCommand;

public interface ExerciseCommandService {

    Long handle(CreateExerciseCommand command);
}
