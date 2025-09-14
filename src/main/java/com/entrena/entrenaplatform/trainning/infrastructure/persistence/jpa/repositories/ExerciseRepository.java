package com.entrena.entrenaplatform.trainning.infrastructure.persistence.jpa.repositories;

import com.entrena.entrenaplatform.trainning.domain.model.aggregates.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    boolean existsByNameAndMuscleGroup(String name, String muscleGroup);
}
