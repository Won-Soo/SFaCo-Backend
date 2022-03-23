package wonsoo.sfaco.web.login;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wonsoo.sfaco.domain.login.LoginService;
import wonsoo.sfaco.domain.user.User;
import wonsoo.sfaco.domain.user.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class LoginController {

    private final LoginService loginService;
    private final UserService userService;


    /**
     * 로그인 API
     */
    @GetMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest request) {

        int result = loginService.login(request.getLoginId(), request.getPassword());

        Map<String, Object> response = new HashMap<>();

        if (result == 1) {
            response.put("result", "FAIL");
            response.put("message", "Do not exist ID");
        } else if (result == 2) {
            response.put("result", "FAIL");
            response.put("message", "Do not exist Password");
        } else {  // 로그인 성공
            User loginUser = userService.findByLoginId(request.getLoginId());
            response.put("result", "SUCCESS");
            response.put("message", "Hello, " + loginUser.getNickname());
        }

        return response;
    }

    @Getter
    static class LoginRequest {
        private String loginId;
        private String password;
    }

}
