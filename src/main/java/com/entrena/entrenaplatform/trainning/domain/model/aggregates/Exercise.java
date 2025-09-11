package com.entrena.entrenaplatform.trainning.domain.model.aggregates;

import com.entrena.entrenaplatform.trainning.domain.model.commands.CreateExerciseCommand;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Exercise {

    @Id
    private Long id;

    @Setter
    private String name;

    @Setter
    private String description;

    @Setter
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

    //todo: add update method with command
    public void updateExercise(){}


}
