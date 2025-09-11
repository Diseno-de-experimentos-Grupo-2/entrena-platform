package com.entrena.entrenaplatform.trainning.domain.model.aggregates;


import com.entrena.entrenaplatform.trainning.domain.model.commands.CreateRoutineCommand;
import com.entrena.entrenaplatform.trainning.domain.model.entities.RoutineItem;
import com.entrena.entrenaplatform.trainning.domain.model.valueobjects.ClientId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Routine {

    @Id
    private Long id;

    @Setter
    private String title;

    @Setter
    private String description;

    @Embedded
    @Setter
    private ClientId clientId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "routine_id")
    @OrderBy("orderIndex ASC")
    private List<RoutineItem> exercises = new ArrayList<>();

    public Routine(CreateRoutineCommand command){
        this.title = command.title();
        this.description = command.description();
    }

    //basic constructor
    public Routine(){}
}
