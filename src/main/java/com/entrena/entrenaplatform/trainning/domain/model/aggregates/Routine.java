package com.entrena.entrenaplatform.trainning.domain.model.aggregates;


import com.entrena.entrenaplatform.trainning.domain.model.commands.CreateRoutineCommand;
import com.entrena.entrenaplatform.trainning.domain.model.commands.UpdateRoutineCommand;
import com.entrena.entrenaplatform.trainning.domain.model.entities.RoutineItem;
import com.entrena.entrenaplatform.trainning.domain.model.valueobjects.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Entity
@Table(name = "routines")
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String title;

    @Setter
    @Column(columnDefinition = "TEXT")
    private String description;

    @Embedded
    @Setter

    private ClientId clientId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "routine_id")
    @OrderBy("orderIndex ASC")
    private List<RoutineItem> exercises = new ArrayList<>();

    public Routine(CreateRoutineCommand command) {
        this.title = command.title();
        this.description = command.description();
        this.clientId = new ClientId(command.clientId());
    }

    //basic constructor
    public Routine() {
    }

    public void updateRoutine(UpdateRoutineCommand command) {
        this.title = command.title();
        this.description = command.description();
    }

    public void addExercise(ExerciseId exerciseId, Sets sets, Reps reps, RestTime restTime, Integer orderIndex) {
        var routineItem = new RoutineItem(exerciseId, sets, reps, restTime, orderIndex);
        this.exercises.add(routineItem);
    }

    public void removeExercise(Long routineItemId) {
        this.exercises.removeIf(item -> item.getId().equals(routineItemId));
    }

    public Optional<RoutineItem> findExerciseById(Long routineItemId) {
        return this.exercises.stream()
                .filter(item -> item.getId().equals(routineItemId))
                .findFirst();
    }

    public void updateExerciseDetails(Long routineItemId, Sets sets, Reps reps, RestTime restTime) {
        findExerciseById(routineItemId)
                .ifPresent(item -> item.updateExerciseDetails(sets, reps, restTime));
    }




}
