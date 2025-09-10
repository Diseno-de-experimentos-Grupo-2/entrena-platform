package com.entrena.entrenaplatform.IAM.infrastructure.tokens.jwt;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Interfaz para el servicio de tokens JWT.
 * Permite extraer el token, validar y obtener el usuario.
 */
public interface BearerTokenService {
    String getBearerTokenFrom(HttpServletRequest token);
    boolean validateToken(String token);
    String getUsernameFromToken(String token);
}
