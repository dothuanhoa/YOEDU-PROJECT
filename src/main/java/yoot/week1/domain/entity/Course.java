package yoot.week1.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import yoot.week1.domain.AuditableEntity;

@Entity
@Data
@NoArgsConstructor
@Table(name = "courses")
public class Course extends AuditableEntity {

    @Column(columnDefinition = "varchar(20)")
    private String courseCode;

    @Column(columnDefinition = "varchar(100)")
    private String name;

    @Column(columnDefinition = "varchar(500)")
    private String description;

    @Column(columnDefinition = "DECIMAL(10,2)")
    private double tuitionFee;

    private int totalSessions;

    private boolean isActive;
}
