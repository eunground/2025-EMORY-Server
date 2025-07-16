package emory.emoryserver.domain.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    // 1.3 사용자 프로필 조회
    @GetMapping("/profile")
    public ResponseEntity<String> getProfile() {
        return ResponseEntity.ok("사용자 프로필 조회");
    }

    // 1.4.1 개인정보 수정
    @PutMapping("/profile")
    public ResponseEntity<String> updateProfile() {
        return ResponseEntity.ok("개인정보 수정 완료");
    }

    // 1.4.2 감정일기 설정 수정
    @PutMapping("/setting/reminder")
    public ResponseEntity<String> updateEmotionDiarySettings() {
        return ResponseEntity.ok("감정일기 설정 수정 완료");
    }

    // 1.4.3 이메일/비밀번호 변경
    @PutMapping("/account")
    public ResponseEntity<String> updateAccount() {
        return ResponseEntity.ok("이메일/비밀번호 변경 완료");
    }

    // 1.4.4 회원 탈퇴
    @DeleteMapping("/account")
    public ResponseEntity<String> deleteAccount() {
        return ResponseEntity.ok("회원 탈퇴 완료");
    }
}
