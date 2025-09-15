package com.entrena.entrenaplatform.trainning.interfaces.rest;


import com.entrena.entrenaplatform.trainning.domain.model.commands.*;
import com.entrena.entrenaplatform.trainning.domain.model.queries.GetAllRoutinesQuery;
import com.entrena.entrenaplatform.trainning.domain.model.queries.GetRoutineByIdQuery;
import com.entrena.entrenaplatform.trainning.domain.model.queries.GetRoutinesByClientIdQuery;
import com.entrena.entrenaplatform.trainning.domain.services.RoutineCommandService;
import com.entrena.entrenaplatform.trainning.domain.services.RoutineQueryService;
import com.entrena.entrenaplatform.trainning.interfaces.rest.resources.*;
import com.entrena.entrenaplatform.trainning.interfaces.rest.transform.CreateRoutineCommandFromResourceAssembler;
import com.entrena.entrenaplatform.trainning.interfaces.rest.transform.RoutineResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/v1/routines", produces = APPLICATION_JSON_VALUE)
public class RoutineController {

    private final RoutineCommandService routineCommandService;
    private final RoutineQueryService routineQueryService;

    public RoutineController(RoutineCommandService routineCommandService, RoutineQueryService routineQueryService) {
        this.routineCommandService = routineCommandService;
        this.routineQueryService = routineQueryService;
    }

    // ==================== GESTIÓN DE RUTINAS ====================

    @PostMapping
    //@Operation(summary = "Create new routine", description = "Create a new routine for a client")
    public ResponseEntity<RoutineResource> createRoutine(@RequestBody CreateRoutineResource resource) {
        var createRoutineCommand = CreateRoutineCommandFromResourceAssembler.toCommandFromResource(resource);
        var routineId = routineCommandService.handle(createRoutineCommand);

        var getRoutineByIdQuery = new GetRoutineByIdQuery(routineId);
        var routine = routineQueryService.handle(getRoutineByIdQuery);

        if (routine.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        var routineResource = RoutineResourceFromEntityAssembler.toResourceFromEntity(routine.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(routineResource);
    }

    @GetMapping
    //@Operation(summary = "Get all routines", description = "Retrieve all routines")
    public ResponseEntity<List<RoutineResource>> getAllRoutines() {
        var routines = routineQueryService.handle(new GetAllRoutinesQuery());
        var routineResources = routines.stream()
                .map(RoutineResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(routineResources);
    }

    @GetMapping("/{routineId}")
    //@Operation(summary = "Get routine by ID", description = "Retrieve a specific routine with all its exercises")
    public ResponseEntity<RoutineResource> getRoutineById(@PathVariable Long routineId) {
        var getRoutineByIdQuery = new GetRoutineByIdQuery(routineId);
        var routine = routineQueryService.handle(getRoutineByIdQuery);

        if (routine.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var routineResource = RoutineResourceFromEntityAssembler.toResourceFromEntity(routine.get());
        return ResponseEntity.ok(routineResource);
    }

    @GetMapping("/client/{clientId}")
    //@Operation(summary = "Get routines by client", description = "Retrieve all routines for a specific client")
    public ResponseEntity<List<RoutineResource>> getRoutinesByClientId(@PathVariable Long clientId) {
        var getRoutinesByClientIdQuery = new GetRoutinesByClientIdQuery(clientId);
        var routines = routineQueryService.handle(getRoutinesByClientIdQuery);
        var routineResources = routines.stream()
                .map(RoutineResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(routineResources);
    }

    @PutMapping("/{routineId}")
    //@Operation(summary = "Update routine", description = "Update routine general information")
    public ResponseEntity<RoutineResource> updateRoutine(@PathVariable Long routineId, @RequestBody UpdateRoutineResource resource) {
        var updateRoutineCommand = new UpdateRoutineCommand(routineId, resource.title(), resource.description());
        routineCommandService.handle(updateRoutineCommand);

        var getRoutineByIdQuery = new GetRoutineByIdQuery(routineId);
        var routine = routineQueryService.handle(getRoutineByIdQuery);

        if (routine.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var routineResource = RoutineResourceFromEntityAssembler.toResourceFromEntity(routine.get());
        return ResponseEntity.ok(routineResource);
    }

    @DeleteMapping("/{routineId}")
    //@Operation(summary = "Delete routine", description = "Delete a complete routine")
    public ResponseEntity<?> deleteRoutine(@PathVariable Long routineId) {
        var deleteRoutineCommand = new DeleteRoutineCommand(routineId);
        routineCommandService.handle(deleteRoutineCommand);
        return ResponseEntity.ok("Routine with given id successfully deleted");
    }

    // ==================== GESTIÓN DE EJERCICIOS EN RUTINAS ====================

    @PostMapping("/{routineId}/exercises")
    //@Operation(summary = "Add exercise to routine", description = "Add an exercise from the catalog to a routine")
    public ResponseEntity<RoutineResource> addExerciseToRoutine(@PathVariable Long routineId, @RequestBody AddExerciseToRoutineResource resource) {
        var addExerciseCommand = new AddExerciseToRoutineCommand(
                routineId,
                resource.exerciseId(),
                resource.sets(),
                resource.reps(),
                resource.restTimeSeconds(),
                resource.orderIndex()
        );
        routineCommandService.handle(addExerciseCommand);

        var getRoutineByIdQuery = new GetRoutineByIdQuery(routineId);
        var routine = routineQueryService.handle(getRoutineByIdQuery);

        if (routine.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var routineResource = RoutineResourceFromEntityAssembler.toResourceFromEntity(routine.get());
        return ResponseEntity.ok(routineResource);
    }

    @PutMapping("/{routineId}/exercises/{routineItemId}")
    //@Operation(summary = "Update exercise in routine", description = "Update exercise details within a routine (sets, reps, rest time)")
    public ResponseEntity<RoutineResource> updateExerciseInRoutine(
            @PathVariable Long routineId,
            @PathVariable Long routineItemId,
            @RequestBody UpdateRoutineItemResource resource) {

        var updateRoutineItemCommand = new UpdateRoutineItemCommand(
                routineId,
                routineItemId,
                resource.sets(),
                resource.reps(),
                resource.restTimeSeconds()
        );
        routineCommandService.handle(updateRoutineItemCommand);

        var getRoutineByIdQuery = new GetRoutineByIdQuery(routineId);
        var routine = routineQueryService.handle(getRoutineByIdQuery);

        if (routine.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var routineResource = RoutineResourceFromEntityAssembler.toResourceFromEntity(routine.get());
        return ResponseEntity.ok(routineResource);
    }

    @DeleteMapping("/{routineId}/exercises/{routineItemId}")
    //@Operation(summary = "Remove exercise from routine", description = "Remove an exercise from a routine")
    public ResponseEntity<RoutineResource> removeExerciseFromRoutine(
            @PathVariable Long routineId,
            @PathVariable Long routineItemId) {

        var removeExerciseCommand = new RemoveExerciseFromRoutineCommand(routineId, routineItemId);
        routineCommandService.handle(removeExerciseCommand);

        var getRoutineByIdQuery = new GetRoutineByIdQuery(routineId);
        var routine = routineQueryService.handle(getRoutineByIdQuery);

        if (routine.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var routineResource = RoutineResourceFromEntityAssembler.toResourceFromEntity(routine.get());
        return ResponseEntity.ok(routineResource);
    }





}
