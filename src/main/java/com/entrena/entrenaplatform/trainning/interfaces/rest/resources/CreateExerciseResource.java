package com.entrena.entrenaplatform.trainning.interfaces.rest.resources;

public record CreateExerciseResource(String name, String description, String muscleGroup) {

    public CreateExerciseResource{
        //TODO: Add validations
    }
}
