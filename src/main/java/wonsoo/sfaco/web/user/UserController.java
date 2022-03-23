package wonsoo.sfaco.web.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wonsoo.sfaco.domain.user.Authority;
import wonsoo.sfaco.domain.user.User;
import wonsoo.sfaco.domain.user.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserController {

    private final UserService userService;


    /**
     * 회원 가입 API
     */
    @PostMapping("/users")
    public Map<String, Object> joinUser(@RequestBody JoinUserRequest request) {

        User user = User.builder()
                .loginId(request.getLoginId())
                .password(request.getPassword())
                .name(request.getName())
                .birth(request.getBirth())
                .tel(request.getTel())
                .email(request.getEmail())
                .nickname(request.getNickname())
                .joinedAt(LocalDateTime.now())
                .authority(request.getAuthority())
                .build();

        Map<String, Object> response = new HashMap<>();

        if (userService.join(user) > 0) {
            response.put("result", "SUCCESS");
        } else {
            response.put("result", "FAIL");
            response.put("message", "ID already exists");
        }

        return response;
    }

    @Getter
    static class JoinUserRequest {
        private String loginId;
        private String password;
        private String name;
        private LocalDate birth;
        private String tel;
        private String email;
        private String nickname;
        private Authority authority;
    }

}
