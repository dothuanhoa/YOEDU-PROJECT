package yoot.week1.service;

import yoot.week1.domain.entity.ScheduleSlot;

import java.util.List;
import java.util.Optional;

public interface ScheduleSlotService {
    List<ScheduleSlot> findAll();
    Optional<ScheduleSlot> findById(long id);
    ScheduleSlot save(ScheduleSlot scheduleSlot);
    void deleteById(long id);
}
