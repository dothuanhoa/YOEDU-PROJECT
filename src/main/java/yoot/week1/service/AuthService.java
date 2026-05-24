package yoot.week1.service;

import yoot.week1.domain.entity.User;
import yoot.week1.dto.auth.*;

public interface AuthService {
    AuthResponse login(LoginRequest request);
    AuthResponse refresh(RefreshTokenRequest request);
    void changePassword(String username, ChangePasswordRequest request);
    CurrentUserResponse me(String username);
    User findActiveUserByUsername(String username);
}
