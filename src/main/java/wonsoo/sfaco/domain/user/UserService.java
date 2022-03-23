package wonsoo.sfaco.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    /**
     * 회원 가입
     */
    @Transactional
    public int join(User user) {
        if (findByLoginId(user.getLoginId()) == null) {  // 아이디 중복체크
            userRepository.save(user);
            return 1;
        } else {
            return 0;
        }
    }


    /**
     * 회원 조회
     */
    // 로그인 아이디로 회원 조회
    public User findByLoginId(String loginId) {
        return userRepository.findByLoginId(loginId).orElse(null);
    }

    public User findByLoginId2(String loginId) {
        return userRepository.findByLoginId2(loginId).orElse(null);
    }

    // 회원 전체 조회
    public List<User> findUsers() {
        return userRepository.findAll();
    }

}
