package com.entrena.entrenaplatform.trainning.domain.model.aggregates;


import com.entrena.entrenaplatform.trainning.domain.model.commands.CreateRoutineCommand;
import com.entrena.entrenaplatform.trainning.domain.model.entities.RoutineItem;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Routine {

    @Id
    private Long id;

    @Setter
    private String title;

    @Setter
    private String description;

    public Routine(CreateRoutineCommand command){
        this.title = command.title();
        this.description = command.description();
    }

    //basic constructor
    public Routine(){}
}
