package wonsoo.sfaco.domain.like;

import lombok.Getter;
import wonsoo.sfaco.domain.boardcodi.BoardCodi;
import wonsoo.sfaco.domain.boardcommunity.BoardCommunity;
import wonsoo.sfaco.domain.user.User;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@Table(name = "likes")
public class Like {  // 좋아요

    @Id
    @GeneratedValue
    @Column(name = "like_id")
    private Long id;  // 좋아요 ID

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;  // 회원

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "codi_id")
    private BoardCodi boardCodi;  // 코디 게시판

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "community_id")
    private BoardCommunity boardCommunity;  // 커뮤니티 게시판

}
