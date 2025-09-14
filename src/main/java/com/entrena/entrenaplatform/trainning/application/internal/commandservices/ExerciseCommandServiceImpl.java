package com.entrena.entrenaplatform.trainning.application.internal.commandservices;

import com.entrena.entrenaplatform.trainning.domain.model.aggregates.Exercise;
import com.entrena.entrenaplatform.trainning.domain.model.commands.CreateExerciseCommand;
import com.entrena.entrenaplatform.trainning.domain.model.commands.DeleteExerciseCommand;
import com.entrena.entrenaplatform.trainning.domain.model.commands.UpdateExerciseCommand;
import com.entrena.entrenaplatform.trainning.domain.services.ExerciseCommandService;
import com.entrena.entrenaplatform.trainning.infrastructure.persistence.jpa.repositories.ExerciseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExerciseCommandServiceImpl implements ExerciseCommandService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseCommandServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public Long handle(CreateExerciseCommand command) {
        if (exerciseRepository.existsByNameAndMuscleGroup(command.name(), command.muscleGroup())) {
            throw new RuntimeException("Exercise with same name and muscle group already exists");
        }

        var exercise = new Exercise(command);
        try {
            var savedExercise = exerciseRepository.save(exercise);
            return savedExercise.getId();
        } catch (Exception e) {
            throw new RuntimeException("Error saving exercise: " + e.getMessage(), e);
        }
    }

    @Override
    public void handle(UpdateExerciseCommand command) {
        var exercise = exerciseRepository.findById(command.exerciseId())
                .orElseThrow(() -> new RuntimeException("Exercise not found"));

        try {
            exercise.updateExercise(command);
            exerciseRepository.save(exercise);
        } catch (Exception e) {
            throw new RuntimeException("Error updating exercise: " + e.getMessage(), e);
        }
    }

    @Override
    public void handle(DeleteExerciseCommand command) {
        if (!exerciseRepository.existsById(command.exerciseId())) {
            throw new RuntimeException("Exercise not found");
        }

        try {
            exerciseRepository.deleteById(command.exerciseId());
        } catch (Exception e) {
            throw new RuntimeException("Error deleting exercise: " + e.getMessage(), e);
        }
    }
}
