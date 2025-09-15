package com.entrena.entrenaplatform.trainning.interfaces.rest;

import com.entrena.entrenaplatform.trainning.domain.model.aggregates.Exercise;
import com.entrena.entrenaplatform.trainning.domain.model.commands.DeleteExerciseCommand;
import com.entrena.entrenaplatform.trainning.domain.model.queries.GetAllExercisesQuery;
import com.entrena.entrenaplatform.trainning.domain.model.queries.GetExerciseByIdQuery;
import com.entrena.entrenaplatform.trainning.domain.services.ExerciseCommandService;
import com.entrena.entrenaplatform.trainning.domain.services.ExerciseQueryService;
import com.entrena.entrenaplatform.trainning.interfaces.rest.resources.CreateExerciseResource;
import com.entrena.entrenaplatform.trainning.interfaces.rest.resources.ExerciseResource;
import com.entrena.entrenaplatform.trainning.interfaces.rest.resources.UpdateExerciseResource;
import com.entrena.entrenaplatform.trainning.interfaces.rest.transform.CreateExerciseCommandFromResourceAssembler;
import com.entrena.entrenaplatform.trainning.interfaces.rest.transform.ExerciseResourceFromEntityAssembler;
import com.entrena.entrenaplatform.trainning.interfaces.rest.transform.UpdateExerciseCommandFromResourceAssembler;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/exercises", produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
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


    @DeleteMapping("/{exerciseId}")
    //@Operation(summary = "Delete exercise", description = "Delete an exercise from the catalog")
    public ResponseEntity<?> deleteExercise(@PathVariable Long exerciseId) {
        var deleteExerciseCommand = new DeleteExerciseCommand(exerciseId);
        exerciseCommandService.handle(deleteExerciseCommand);
        return ResponseEntity.ok("Exercise with given id successfully deleted");
    }


    @PostMapping
    //@Operation(summary = "Create new exercise", description = "Create a new exercise in the catalog")
    public ResponseEntity<ExerciseResource> createExercise(@RequestBody CreateExerciseResource resource) {
        var createExerciseCommand = CreateExerciseCommandFromResourceAssembler.toCommandFromResource(resource);
        var exerciseId = exerciseCommandService.handle(createExerciseCommand);

        var getExerciseByIdQuery = new GetExerciseByIdQuery(exerciseId);
        var exercise = exerciseQueryService.handle(getExerciseByIdQuery);

        if (exercise.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        var exerciseResource = ExerciseResourceFromEntityAssembler.toResourceFromEntity(exercise.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(exerciseResource);
    }


    @PutMapping("/{exerciseId}")
    //@Operation(summary = "Update exercise", description = "Update an existing exercise")
    public ResponseEntity<ExerciseResource> updateExercise(@PathVariable Long exerciseId, @RequestBody UpdateExerciseResource resource) {
        var updateExerciseCommand = UpdateExerciseCommandFromResourceAssembler.toCommandFromResource(exerciseId, resource);
        exerciseCommandService.handle(updateExerciseCommand);

        var getExerciseByIdQuery = new GetExerciseByIdQuery(exerciseId);
        var exercise = exerciseQueryService.handle(getExerciseByIdQuery);

        if (exercise.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var exerciseResource = ExerciseResourceFromEntityAssembler.toResourceFromEntity(exercise.get());
        return ResponseEntity.ok(exerciseResource);
    }











}
