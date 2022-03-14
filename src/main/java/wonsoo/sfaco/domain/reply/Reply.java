package wonsoo.sfaco.domain.reply;

import lombok.Getter;
import wonsoo.sfaco.domain.WritingDateInfo;
import wonsoo.sfaco.domain.boardcommunity.BoardCommunity;
import wonsoo.sfaco.domain.user.User;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
public class Reply extends WritingDateInfo {  // 댓글

    @Id
    @GeneratedValue
    @Column(name = "reply_id")
    private Long id;  // 댓글 ID

    @Column(length = 300)
    private String contents;  // 내용

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "writer")
    private User user;  // 회원

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "community_id")
    private BoardCommunity boardCommunity;  // 커뮤니티 게시판

}
