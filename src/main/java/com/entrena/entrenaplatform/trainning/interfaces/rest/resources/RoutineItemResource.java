package com.entrena.entrenaplatform.trainning.interfaces.rest.resources;

import java.util.List;

public record RoutineItemResource(Long id, Long exerciseId, Integer sets, Integer reps, Integer restTimeSeconds, Integer orderIndex) {
}
