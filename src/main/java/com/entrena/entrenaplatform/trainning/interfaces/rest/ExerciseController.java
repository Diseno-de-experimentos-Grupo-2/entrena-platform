package com.entrena.entrenaplatform.trainning.interfaces.rest;

import com.entrena.entrenaplatform.trainning.domain.model.aggregates.Exercise;
import com.entrena.entrenaplatform.trainning.domain.model.commands.DeleteExerciseCommand;
import com.entrena.entrenaplatform.trainning.domain.model.queries.GetAllExercisesQuery;
import com.entrena.entrenaplatform.trainning.domain.model.queries.GetExerciseByIdQuery;
import com.entrena.entrenaplatform.trainning.domain.services.ExerciseCommandService;
import com.entrena.entrenaplatform.trainning.domain.services.ExerciseQueryService;
import com.entrena.entrenaplatform.trainning.interfaces.rest.resources.ExerciseResource;
import com.entrena.entrenaplatform.trainning.interfaces.rest.transform.CreateExerciseCommandFromResourceAssembler;
import com.entrena.entrenaplatform.trainning.interfaces.rest.transform.ExerciseResourceFromEntityAssembler;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/exercises", produces = APPLICATION_JSON_VALUE)
//TODO: add tags and endpoint documentation
public class ExerciseController {

    private final ExerciseCommandService exerciseCommandService;
    private final ExerciseQueryService exerciseQueryService;

    public  ExerciseController(ExerciseQueryService exerciseQueryService, ExerciseCommandService exerciseCommandService){
        this.exerciseCommandService = exerciseCommandService;
        this.exerciseQueryService = exerciseQueryService;
    }

    //GET ALL EXERCISES
    @GetMapping
    public ResponseEntity<List<ExerciseResource>> getAllExercises(){
        var exercises = exerciseQueryService.handle(new GetAllExercisesQuery());
        //TODO: add validations
        var exerciseResources = exercises.stream()
                .map(ExerciseResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(exerciseResources);
    }

    //GET EXERCISE BY ID
    @GetMapping("/{exerciseId}")
    public ResponseEntity<ExerciseResource> getExerciseById(@PathVariable Long exerciseId){
        var getExerciseByIdQuery = new GetExerciseByIdQuery(exerciseId);
        var exercise = exerciseQueryService.handle(getExerciseByIdQuery);
        //TODO: add validations

        var exerciseEntity = exercise.get();
        var exerciseResource = ExerciseResourceFromEntityAssembler.toResourceFromEntity(exerciseEntity);
        return ResponseEntity.ok(exerciseResource);
    }


    public ResponseEntity<?> deleteExercise(@PathVariable Long exerciseId){
        var deleteExerciseCommand = new DeleteExerciseCommand(exerciseId);
        exerciseCommandService.handle(deleteExerciseCommand);
        return ResponseEntity.ok("Exercise with given id successfully deleted");
    }





}
