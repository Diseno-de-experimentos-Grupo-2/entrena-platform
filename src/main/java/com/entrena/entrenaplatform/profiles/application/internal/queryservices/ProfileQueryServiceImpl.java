package com.entrena.entrenaplatform.profiles.application.internal.queryservices;

import com.entrena.entrenaplatform.profiles.domain.model.aggregates.Profile;
import com.entrena.entrenaplatform.profiles.domain.model.queries.GetAllProfilesQuery;
import com.entrena.entrenaplatform.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.entrena.entrenaplatform.profiles.domain.model.queries.GetProfileByIdQuery;
import com.entrena.entrenaplatform.profiles.domain.services.ProfileQueryService;
import com.entrena.entrenaplatform.profiles.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Profile Query Service Implementation
 */
@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {
    private final ProfileRepository profileRepository;

    /**
     * Constructor
     *
     * @param profileRepository The {@link ProfileRepository} instance
     */
    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    // inherited javadoc
    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findById(query.profileId());
    }

    // inherited javadoc
    @Override
    public Optional<Profile> handle(GetProfileByEmailQuery query) {
        return profileRepository.findByEmailAddress(query.emailAddress());
    }

    // inherited javadoc
    @Override
    public List<Profile> handle(GetAllProfilesQuery query) {
        return profileRepository.findAll();
    }
}
