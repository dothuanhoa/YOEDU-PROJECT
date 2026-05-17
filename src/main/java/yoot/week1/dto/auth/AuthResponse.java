package yoot.week1.dto.auth;

import java.time.Instant;

public record AuthResponse(
        String accessToken,
        String refreshToken,
        String tokenType,
        Instant expiresAt,
        Instant refreshExpiresAt,
        CurrentUserResponse user
) {
}
