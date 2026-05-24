package yoot.week1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yoot.week1.domain.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
