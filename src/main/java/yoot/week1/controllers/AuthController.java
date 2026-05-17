package yoot.week1.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yoot.week1.common.ApiResponse;
import yoot.week1.common.exception.BadRequestException;
import yoot.week1.common.exception.NotFoundException;
import yoot.week1.dto.auth.*;
import yoot.week1.service.AuthService;

import java.security.Principal;

@RestController
@RequestMapping(value = "/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(@Valid @RequestBody LoginRequest request){
        return ApiResponse.success("Login successful", authService.login(request));
    }

    @PostMapping("/refresh")
      public ApiResponse<AuthResponse> refresh(@Valid @RequestBody RefreshTokenRequest request) {
        return ApiResponse.success("Token refreshed", authService.refresh(request));
    }

    @PostMapping("/change-password")
    public ApiResponse<Void> changePassword(Principal principal,
                                            @Valid @RequestBody ChangePasswordRequest request)
        throws BadRequestException, NotFoundException{
        authService.changePassword(principal.getName(), request);
        return ApiResponse.successMessage("Password changed successfully");
    }

    @GetMapping("/me")
    public ApiResponse<CurrentUserResponse> me(Principal principal){
        return ApiResponse.success(authService.me(principal.getName()));
    }

}
