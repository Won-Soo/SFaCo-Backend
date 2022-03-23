package wonsoo.sfaco.domain.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import wonsoo.sfaco.domain.user.User;
import wonsoo.sfaco.domain.user.UserService;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserService userService;

    public int login(String loginId, String password) {
        User findUser = userService.findByLoginId(loginId);
        if (findUser == null) {  // id가 틀림
            return 1;
        } else {
            if (findUser.getPassword().equals(password)) {  // 로그인 성공
                return 0;
            } else {  // PW가 틀림
                return 2;
            }
        }
    }

}
