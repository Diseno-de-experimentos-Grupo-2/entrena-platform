package com.entrena.entrenaplatform.trainning.interfaces.rest.resources;

import java.util.List;

public record RoutineResource(Long id, String title, String description, Long clientId, List<RoutineItemResource> exercises) {
}
