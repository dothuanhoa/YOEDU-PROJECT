package yoot.week1.dto.request;

public record UpdateParentRequest (
        String fullName,
        String phone,
        String email,
        String address
){
}
