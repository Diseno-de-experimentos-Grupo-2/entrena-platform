package com.entrena.entrenaplatform.trainning.application.internal.commandservices;


import com.entrena.entrenaplatform.trainning.domain.model.aggregates.Routine;
import com.entrena.entrenaplatform.trainning.domain.model.commands.*;
import com.entrena.entrenaplatform.trainning.domain.model.valueobjects.ExerciseId;
import com.entrena.entrenaplatform.trainning.domain.model.valueobjects.Reps;
import com.entrena.entrenaplatform.trainning.domain.model.valueobjects.RestTime;
import com.entrena.entrenaplatform.trainning.domain.model.valueobjects.Sets;
import com.entrena.entrenaplatform.trainning.domain.services.RoutineCommandService;
import com.entrena.entrenaplatform.trainning.infrastructure.persistence.jpa.repositories.ExerciseRepository;
import com.entrena.entrenaplatform.trainning.infrastructure.persistence.jpa.repositories.RoutineRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoutineCommandServiceImpl implements RoutineCommandService {


    private final RoutineRepository routineRepository;
    private final ExerciseRepository exerciseRepository;

    public RoutineCommandServiceImpl(RoutineRepository routineRepository, ExerciseRepository exerciseRepository) {
        this.routineRepository = routineRepository;
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public Long handle(CreateRoutineCommand command) {
        var routine = new Routine(command);
        try {
            var savedRoutine = routineRepository.save(routine);
            return savedRoutine.getId();
        } catch (Exception e) {
            throw new RuntimeException("Error creating routine: " + e.getMessage(), e);
        }
    }

    @Override
    public void handle(UpdateRoutineCommand command) {
        var routine = routineRepository.findById(command.routineId())
                .orElseThrow(() -> new RuntimeException("Routine not found"));

        try {
            routine.updateRoutine(command);
            routineRepository.save(routine);
        } catch (Exception e) {
            throw new RuntimeException("Error updating routine: " + e.getMessage(), e);
        }
    }

    @Override
    public void handle(DeleteRoutineCommand command) {
        if (!routineRepository.existsById(command.routineId())) {
            throw new RuntimeException("Routine not found");
        }

        try {
            routineRepository.deleteById(command.routineId());
        } catch (Exception e) {
            throw new RuntimeException("Error deleting routine: " + e.getMessage(), e);
        }
    }

    @Override
    public void handle(AddExerciseToRoutineCommand command) {
        var routine = routineRepository.findById(command.routineId())
                .orElseThrow(() -> new RuntimeException("Routine not found"));

        if (!exerciseRepository.existsById(command.exerciseId())) {
            throw new RuntimeException("Exercise not found");
        }

        try {
            routine.addExercise(
                    new ExerciseId(command.exerciseId()),
                    new Sets(command.sets()),
                    new Reps(command.reps()),
                    new RestTime(command.restTimeSeconds()),
                    command.orderIndex()
            );
            routineRepository.save(routine);
        } catch (Exception e) {
            throw new RuntimeException("Error adding exercise to routine: " + e.getMessage(), e);
        }
    }

    @Override
    public void handle(UpdateRoutineItemCommand command) {
        var routine = routineRepository.findById(command.routineId())
                .orElseThrow(() -> new RuntimeException("Routine not found"));

        try {
            Sets sets = command.sets() != null ? new Sets(command.sets()) : null;
            Reps reps = command.reps() != null ? new Reps(command.reps()) : null;
            RestTime restTime = command.restTimeSeconds() != null ? new RestTime(command.restTimeSeconds()) : null;

            routine.updateExerciseDetails(command.routineItemId(), sets, reps, restTime);
            routineRepository.save(routine);
        } catch (Exception e) {
            throw new RuntimeException("Error updating routine item: " + e.getMessage(), e);
        }
    }

    @Override
    public void handle(RemoveExerciseFromRoutineCommand command) {
        var routine = routineRepository.findById(command.routineId())
                .orElseThrow(() -> new RuntimeException("Routine not found"));

        try {
            routine.removeExercise(command.routineItemId());
            routineRepository.save(routine);
        } catch (Exception e) {
            throw new RuntimeException("Error removing exercise from routine: " + e.getMessage(), e);
        }
    }
}
