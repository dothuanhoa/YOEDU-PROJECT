package yoot.week1.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import yoot.week1.domain.AuditableEntity;
import yoot.week1.domain.enums.UserRole;

@Entity
@Data
@Table(name="users")
public class User extends AuditableEntity {
    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 255)
    private String passwordHash;

    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(length = 20)
    private String phone;

    @Column(length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Column(name = "is_active")
    private Boolean isActive = true;
}
