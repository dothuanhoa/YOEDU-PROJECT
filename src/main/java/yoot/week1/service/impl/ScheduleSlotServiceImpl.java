package yoot.week1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yoot.week1.domain.entity.ScheduleSlot;
import yoot.week1.repository.ScheduleSlotRepository;
import yoot.week1.service.ScheduleSlotService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleSlotServiceImpl implements ScheduleSlotService {
    private final ScheduleSlotRepository scheduleSlotRepository;

    public List<ScheduleSlot> findAll(){
        return scheduleSlotRepository.findAll();
    }

    public Optional<ScheduleSlot> findById(long id){
        return scheduleSlotRepository.findById(id);
    }
    public ScheduleSlot save(ScheduleSlot scheduleSlot){
        return scheduleSlotRepository.save(scheduleSlot);
    }
    public void deleteById(long id){
        scheduleSlotRepository.deleteById(id);
    }
}
