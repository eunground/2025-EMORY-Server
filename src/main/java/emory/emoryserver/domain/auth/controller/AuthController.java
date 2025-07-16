package emory.emoryserver.domain.auth.controller;

import emory.emoryserver.domain.auth.dto.request.LoginRequestDto;
import emory.emoryserver.domain.auth.dto.response.LoginResponseDto;
import emory.emoryserver.domain.auth.dto.request.SignupRequestDto;
import emory.emoryserver.domain.user.service.UserService;
import emory.emoryserver.global.config.auth.JwtTokenProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    // 1.1 이메일 회원가입
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody SignupRequestDto requestDto) {
        userService.signup(requestDto);
        return ResponseEntity.ok("이메일 회원가입 완료");
    }

    // 1.2 SNS 로그인
    @PostMapping("/oauth")
    public ResponseEntity<String> oauthLogin() {
        return ResponseEntity.ok("SNS 로그인 완료");
    }

    // 1.3 일반 로그인
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginRequestDto requestDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            requestDto.getEmail(), requestDto.getPassword()
                    )
            );

            String token = jwtTokenProvider.createToken(authentication.getName());

            return ResponseEntity.ok(new LoginResponseDto(token));

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).build();
        }
    }
}