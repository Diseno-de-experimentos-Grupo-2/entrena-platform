package com.entrena.entrenaplatform.IAM.infrastructure.hashing.bcrypt;


import com.entrena.entrenaplatform.IAM.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * This interface is a marker interface for the BCrypt hashing service.
 * It extends the {@link HashingService} and {@link PasswordEncoder} interfaces.
 * This interface is used para inyectar el servicio BCrypt en la clase {@link com.entrena.entrenaplatform.IAM.infrastructure.hashing.bcrypt.services.HashingServiceImpl}.
 */
public interface BCryptHashingService extends HashingService, PasswordEncoder {
}
