package com.entrena.entrenaplatform.trainning.application.internal.commandservices;

import com.entrena.entrenaplatform.trainning.domain.model.aggregates.Exercise;
import com.entrena.entrenaplatform.trainning.domain.model.commands.CreateExerciseCommand;
import com.entrena.entrenaplatform.trainning.domain.services.ExerciseCommandService;
import com.entrena.entrenaplatform.trainning.infrastructure.persistence.jpa.repositories.ExerciseRepository;
import org.springframework.stereotype.Service;

@Service
public class ExerciseCommandServiceImpl implements ExerciseCommandService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseCommandServiceImpl(ExerciseRepository exerciseRepository){
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public Long handle(CreateExerciseCommand command) {
        //TODO: Add validations

        var exercise = new Exercise(command);
        try{
            exerciseRepository.save(exercise);
        }catch (Exception e){
            throw new RuntimeException("Error saving exercise: " + e.getMessage(), e);
        }
        return exercise.getId();
    }
}
