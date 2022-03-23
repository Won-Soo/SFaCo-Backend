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


    /**
     * ID 찾기 API
     */
    @GetMapping("/users/findId")
    public Map<String, Object> findLoginId(@RequestBody findLoginIdRequest request) {

        int result = loginService.findLoginId(request.getName(), request.getTel());

        Map<String, Object> response = new HashMap<>();

        if (result > 0) {
            response.put("result", "FAIL");
            response.put("message", "Do not exist User Info");
        } else {  // ID 찾기 성공
            User findUser = userService.findByTel(request.getTel());
            response.put("result", "SUCCESS");
            response.put("message", "ID: " + findUser.getLoginId());
        }

        return response;
    }

    @Getter
    static class findLoginIdRequest {
        private String name;
        private String tel;
    }


    /**
     * Password 찾기 API
     */
    @GetMapping("/users/findPassword")
    public Map<String, Object> findPassword(@RequestBody findPasswordRequest request) {

        int result = loginService.findPassword(request.getLoginId(), request.getName(), request.getEmail());

        System.out.println("result = " + result);

        Map<String, Object> response = new HashMap<>();

        if (result > 0) {
            response.put("result", "FAIL");
            response.put("message", "Do not exist User Info");
        } else {  // 로그인 성공
            User loginUser = userService.findByLoginId(request.getLoginId());
            response.put("result", "SUCCESS");
            response.put("message", "Password: " + loginUser.getPassword());
        }

        return response;
    }

    @Getter
    static class findPasswordRequest {
        private String loginId;
        private String name;
        private String email;
    }

}
