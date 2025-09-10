package com.entrena.entrenaplatform.trainning.domain.services;

import com.entrena.entrenaplatform.trainning.domain.model.aggregates.Exercise;
import com.entrena.entrenaplatform.trainning.domain.model.queries.GetAllExercisesQuery;
import com.entrena.entrenaplatform.trainning.domain.model.queries.GetExerciseByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ExerciseQueryService {

    Optional<Exercise> handle(GetExerciseByIdQuery query);
    List<Exercise> handle(GetAllExercisesQuery query);
}
