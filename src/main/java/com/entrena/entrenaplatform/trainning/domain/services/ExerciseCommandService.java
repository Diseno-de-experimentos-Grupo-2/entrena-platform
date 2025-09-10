package com.entrena.entrenaplatform.trainning.domain.services;

import com.entrena.entrenaplatform.trainning.domain.model.commands.AddExerciseToRoutineCommand;
import com.entrena.entrenaplatform.trainning.domain.model.commands.CreateExerciseCommand;
import com.entrena.entrenaplatform.trainning.domain.model.commands.DeleteExerciseCommand;

public interface ExerciseCommandService {

    Long handle(CreateExerciseCommand command);

    void handle(DeleteExerciseCommand command);
}
