package yoot.week1.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import yoot.week1.domain.AuditableEntity;

import java.time.LocalTime;

@Data
@Table(name = "schedule_slots")
@Entity
public class ScheduleSlot extends AuditableEntity {
    @Column(columnDefinition = "varchar(20)")
    private String slotCode;

    private byte weekday;

    private LocalTime startTime;

    private LocalTime endTime;

    @Column(columnDefinition = "varchar(255)")
    private String note;
}
