package yoot.week1.dto.parent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParentResponse {
    private Long id;
    private String fullName;
    private String phone;
    private String email;
    private String address;
    private String relationship;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
