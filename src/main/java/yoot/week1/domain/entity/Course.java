package yoot.week1.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import yoot.week1.domain.AuditableEntity;

@Entity
@Data
@Table(name = "courses")
public class Course extends AuditableEntity {

    @Column(length = 20)
    private String courseCode;

    @Column(length = 100)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(columnDefinition = "DECIMAL(10,2)")
    private double tuitionFee;

    private int totalSessions;

    private boolean active;
}
