package com.entrena.entrenaplatform.trainning.domain.services;

import com.entrena.entrenaplatform.trainning.domain.model.aggregates.Routine;
import com.entrena.entrenaplatform.trainning.domain.model.queries.GetAllRoutinesQuery;
import com.entrena.entrenaplatform.trainning.domain.model.queries.GetRoutineByIdQuery;
import com.entrena.entrenaplatform.trainning.domain.model.queries.GetRoutinesByClientIdQuery;

import java.util.List;
import java.util.Optional;

public interface RoutineQueryService {

    Optional<Routine> handle(GetRoutineByIdQuery query);
    List<Routine> handle(GetRoutinesByClientIdQuery query);
    List<Routine> handle(GetAllRoutinesQuery query);


}
