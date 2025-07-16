package emory.emoryserver.domain.admin.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    // 1.5 전체 사용자 수 조회
    @GetMapping("/users/count")
    public ResponseEntity<String> getUserCount() {
        return ResponseEntity.ok("전체 사용자 수 조회");
    }
}
