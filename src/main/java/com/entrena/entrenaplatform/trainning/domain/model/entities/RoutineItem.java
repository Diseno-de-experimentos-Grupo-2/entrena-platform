package com.entrena.entrenaplatform.trainning.domain.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class RoutineItem {

    @Id
    private Long id;

    @Setter
    private int sets;

    @Setter
    private float restTime;

    @Setter
    private int reps;


}
