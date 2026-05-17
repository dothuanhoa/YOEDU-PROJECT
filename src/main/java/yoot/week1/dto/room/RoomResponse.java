package yoot.week1.dto.room;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RoomResponse {
    private Long id;
    private String room_code;
    private String name;
    private Integer capacity;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
