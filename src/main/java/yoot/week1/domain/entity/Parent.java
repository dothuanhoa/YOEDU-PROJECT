package yoot.week1.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;
import yoot.week1.domain.AuditableEntity;

@Entity
@Data
@Table(name = "parents")
public class Parent extends AuditableEntity {
    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String fullName;

    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String phone;

    @Column(columnDefinition = "varchar(100)")
    @Email
    private String email;

    @Column(columnDefinition = "varchar(255)")
    private String address;
}
