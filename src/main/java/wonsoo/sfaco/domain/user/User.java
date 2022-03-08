package wonsoo.sfaco.domain.user;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
public class User {  // 회원

    @Id
    @Column(name = "user_id")
    private String id;  // 아이디

    private String password;  // 비밀번호
    private String name;  // 이름
    private LocalDate birth;  // 생년월일
    private String tel;  // 전화번호
    private String email;  // 이메일
    private String nickname;  // 닉네임
    private LocalDateTime joinedAt;  // 가입일자

    @Column(length = 5)
    @Enumerated(EnumType.STRING)
    private Authority authority;  // 관리권한

}
