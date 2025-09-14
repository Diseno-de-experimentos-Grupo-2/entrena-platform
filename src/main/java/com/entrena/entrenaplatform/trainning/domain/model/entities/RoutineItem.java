package com.entrena.entrenaplatform.trainning.domain.model.entities;


import com.entrena.entrenaplatform.trainning.domain.model.valueobjects.ExerciseId;
import com.entrena.entrenaplatform.trainning.domain.model.valueobjects.Reps;
import com.entrena.entrenaplatform.trainning.domain.model.valueobjects.RestTime;
import com.entrena.entrenaplatform.trainning.domain.model.valueobjects.Sets;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "routine_items")
public class RoutineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @Setter
    private ExerciseId exerciseId;

    @Embedded
    @Setter
    private Sets sets;

    @Embedded
    @Setter
    private Reps reps;

    @Embedded
    @Setter
    private RestTime restTime;

    @Setter
    @Column(name = "order_index")
    private Integer orderIndex;

    public RoutineItem(ExerciseId exerciseId, Sets sets, Reps reps, RestTime restTime, Integer orderIndex) {
        this.exerciseId = exerciseId;
        this.sets = sets;
        this.reps = reps;
        this.restTime = restTime;
        this.orderIndex = orderIndex;
    }

    public RoutineItem() {

    }


    public void updateExerciseDetails(Sets sets, Reps reps, RestTime restTime) {
        if (sets != null) this.sets = sets;
        if (reps != null) this.reps = reps;
        if (restTime != null) this.restTime = restTime;
    }


}
