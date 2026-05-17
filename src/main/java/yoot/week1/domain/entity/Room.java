package yoot.week1.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import yoot.week1.domain.AuditableEntity;

@Entity
@Table(name = "rooms")
@Data
public class Room extends AuditableEntity {
    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String room_code;

    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String name;

    private int capacity;


    private String description;




}
