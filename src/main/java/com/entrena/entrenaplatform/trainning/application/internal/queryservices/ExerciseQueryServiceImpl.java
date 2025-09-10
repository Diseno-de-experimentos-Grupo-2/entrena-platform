package com.entrena.entrenaplatform.trainning.application.internal.queryservices;

import com.entrena.entrenaplatform.trainning.domain.model.aggregates.Exercise;
import com.entrena.entrenaplatform.trainning.domain.model.queries.GetAllExercisesQuery;
import com.entrena.entrenaplatform.trainning.domain.model.queries.GetExerciseByIdQuery;
import com.entrena.entrenaplatform.trainning.domain.services.ExerciseQueryService;
import com.entrena.entrenaplatform.trainning.infrastructure.persistence.jpa.repositories.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseQueryServiceImpl implements ExerciseQueryService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseQueryServiceImpl(ExerciseRepository exerciseRepository){
         this.exerciseRepository = exerciseRepository;
    }

    @Override
    public Optional<Exercise> handle(GetExerciseByIdQuery query) {
        return exerciseRepository.findById(query.id());
    }

    @Override
    public List<Exercise> handle(GetAllExercisesQuery query) {
        return exerciseRepository.findAll();
    }
}
