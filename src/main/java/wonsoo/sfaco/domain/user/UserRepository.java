package wonsoo.sfaco.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    // 회원 저장
    public void save(User user) {
        em.persist(user);
    }

    // 로그인 아이디로 회원 조회
    public Optional<User> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(user -> user.getLoginId().equals(loginId))
                .findFirst();
    }

    public Optional<User> findByLoginId2(String loginId) {
        List<User> findUserList = em.createQuery("select u from User u where u.loginId = :loginId", User.class).setParameter("loginId", loginId).getResultList();
        return findUserList.stream().findFirst();
    }

    // 회원 전체 조회
    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

}
