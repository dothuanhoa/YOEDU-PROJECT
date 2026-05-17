package yoot.week1.dto.room;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class RoomUpsertRequest {
    @Length(min = 1, max = 200)
    private String room_code;

    @Length(max = 100)
    @NotBlank
    private String name;

    @Min(1)
    private Integer capacity = 25;
    private String description;
}
