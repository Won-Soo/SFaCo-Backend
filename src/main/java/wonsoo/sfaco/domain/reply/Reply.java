package wonsoo.sfaco.domain.reply;

import lombok.Getter;
import wonsoo.sfaco.domain.boardcommunity.BoardCommunity;
import wonsoo.sfaco.domain.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
public class Reply {  // 댓글

    @Id
    @GeneratedValue
    @Column(name = "reply_id")
    private Long id;  // 댓글 ID

    @Column(length = 300)
    private String contents;  // 내용

    private LocalDateTime createdAt;  // 작성일자
    private LocalDateTime modifiedAt;  // 수정일자
    private LocalDateTime deletedAt;  // 삭제일자

    private User user;  // 회원
    private BoardCommunity boardCommunity;  // 커뮤니티 게시판

}
