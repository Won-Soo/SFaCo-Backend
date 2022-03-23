package wonsoo.sfaco.domain.user;

import lombok.Builder;
import lombok.Getter;
import wonsoo.sfaco.domain.boardcodi.BoardCodi;
import wonsoo.sfaco.domain.boardcommunity.BoardCommunity;
import wonsoo.sfaco.domain.like.Like;
import wonsoo.sfaco.domain.reply.Reply;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User {  // 회원

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;  // 회원 ID

    private String loginId;  // 아이디
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

    @OneToMany(mappedBy = "user")
    private List<BoardCodi> codiList = new ArrayList<>();  // 코디 게시판

    @OneToMany(mappedBy = "user")
    private List<BoardCommunity> communityList = new ArrayList<>();  // 커뮤니티 게시판

    @OneToMany(mappedBy = "user")
    private List<Reply> replyList = new ArrayList<>();  // 댓글

    @OneToMany(mappedBy = "user")
    private List<Like> likeList = new ArrayList<>();  // 좋아요

    //== 생성자 ==//
    public User() {
    }

    @Builder
    public User(String loginId, String password, String name, LocalDate birth, String tel, String email, String nickname, LocalDateTime joinedAt, Authority authority) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.tel = tel;
        this.email = email;
        this.nickname = nickname;
        this.joinedAt = joinedAt;
        this.authority = authority;
    }

}