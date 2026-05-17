package yoot.week1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import yoot.week1.security.JwtAuthenticationFilter;

@Configuration  //báo Spring chạy trước các annotation khác như service
@EnableWebSecurity
@EnableMethodSecurity //cho phép dùng các annotation trên method để nhìn trực quan hơn trên tác vụ cụ thể
public class SecurityConfig {
    //csrf bị khi lên tới web (ví dụ chống hacker truyền script cho admin xóa user),
    //api không bị.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception{
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors->cors.disable())
                .sessionManagement(sessionmManagement -> sessionmManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        //những route không cần đăng nhập thì khai báo ra (ở đây chưa cần đăng nhập mới vô link login được)
                        .requestMatchers(HttpMethod.POST, "/api/auth/login")
                        .permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/auth/refresh")
                        .permitAll()
                        .requestMatchers(HttpMethod.POST, "/error")
                        .permitAll()
                        .anyRequest().authenticated()).addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
