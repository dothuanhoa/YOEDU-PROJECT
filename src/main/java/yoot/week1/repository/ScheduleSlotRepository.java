package yoot.week1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yoot.week1.domain.entity.ScheduleSlot;

public interface ScheduleSlotRepository extends JpaRepository<ScheduleSlot, Long> {
}
