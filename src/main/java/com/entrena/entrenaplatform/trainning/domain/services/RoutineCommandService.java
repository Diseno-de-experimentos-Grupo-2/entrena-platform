package com.entrena.entrenaplatform.trainning.domain.services;

import com.entrena.entrenaplatform.trainning.domain.model.commands.*;

public interface RoutineCommandService {
    Long handle(CreateRoutineCommand command);
    void handle(UpdateRoutineCommand command);
    void handle(DeleteRoutineCommand command);
    void handle(AddExerciseToRoutineCommand command);
    void handle(UpdateRoutineItemCommand command);
    void handle(RemoveExerciseFromRoutineCommand command);
}
