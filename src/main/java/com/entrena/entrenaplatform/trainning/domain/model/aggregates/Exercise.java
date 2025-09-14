package com.entrena.entrenaplatform.trainning.domain.model.aggregates;

import com.entrena.entrenaplatform.trainning.domain.model.commands.CreateExerciseCommand;
import com.entrena.entrenaplatform.trainning.domain.model.commands.UpdateExerciseCommand;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    private Long id;

    @Setter
    @Column(nullable = false)
    private String name;

    @Setter
    @Column(columnDefinition = "TEXT")
    private String description;

    @Setter
    @Column(name = "muscle_group", nullable = false)
    private String muscleGroup;

    public Exercise(String name, String description, String muscleGroup) {
        this.name = name;
        this.description = description;
        this.muscleGroup = muscleGroup;
    }

    public Exercise(CreateExerciseCommand command){
        this.name = command.name();
        this.description = command.description();
        this.muscleGroup = command.muscleGroup();

    }

    //basic constructor
    public Exercise() {
    }

    public void updateExercise(UpdateExerciseCommand command) {
        this.name = command.name();
        this.description = command.description();
        this.muscleGroup = command.muscleGroup();
    }


}
