package com.entrena.entrenaplatform.trainning.infrastructure.persistence.jpa.repositories;

import com.entrena.entrenaplatform.trainning.domain.model.aggregates.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Long> {


    @Query("SELECT r FROM Routine r WHERE r.clientId.clientId = :clientId")
    List<Routine> findByClientId(@Param("clientId") Long clientId);


}
