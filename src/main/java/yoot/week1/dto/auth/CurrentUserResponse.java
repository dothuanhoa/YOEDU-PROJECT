package yoot.week1.dto.auth;
//username và fullName là dư thừa
public record CurrentUserResponse(
        Long id,
        String username,
        String fullName,
        String role,
        Long parentId,
        Long teacherId
) {
}
