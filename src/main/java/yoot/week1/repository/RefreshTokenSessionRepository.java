package yoot.week1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yoot.week1.domain.entity.RefreshTokenSession;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

//nếu
public interface RefreshTokenSessionRepository extends JpaRepository<RefreshTokenSession, Long> {
    Optional<RefreshTokenSession> findByJti(String jti);

    List<RefreshTokenSession> findByUserIdAndRevokedAtIsNull(long id);

    List<RefreshTokenSession> findByExpiresAtBeforeAndRevokedAtIsNull(Instant now);

}
