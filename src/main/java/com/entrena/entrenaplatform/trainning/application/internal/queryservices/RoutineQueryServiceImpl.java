package com.entrena.entrenaplatform.trainning.application.internal.queryservices;


import com.entrena.entrenaplatform.trainning.domain.model.aggregates.Routine;
import com.entrena.entrenaplatform.trainning.domain.model.queries.GetAllRoutinesQuery;
import com.entrena.entrenaplatform.trainning.domain.model.queries.GetRoutineByIdQuery;
import com.entrena.entrenaplatform.trainning.domain.model.queries.GetRoutinesByClientIdQuery;
import com.entrena.entrenaplatform.trainning.domain.services.RoutineQueryService;
import com.entrena.entrenaplatform.trainning.infrastructure.persistence.jpa.repositories.RoutineRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoutineQueryServiceImpl implements RoutineQueryService {

    private final RoutineRepository routineRepository;

    public RoutineQueryServiceImpl(RoutineRepository routineRepository) {
        this.routineRepository = routineRepository;
    }

    @Override
    public Optional<Routine> handle(GetRoutineByIdQuery query) {
        return routineRepository.findById(query.routineId());
    }

    @Override
    public List<Routine> handle(GetRoutinesByClientIdQuery query) {
        return routineRepository.findByClientId(query.clientId());
    }

    @Override
    public List<Routine> handle(GetAllRoutinesQuery query) {
        return routineRepository.findAll();
    }
}
