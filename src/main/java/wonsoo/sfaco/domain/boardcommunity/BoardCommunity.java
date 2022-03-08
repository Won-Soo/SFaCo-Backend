package wonsoo.sfaco.domain.boardcommunity;

import lombok.Getter;
import wonsoo.sfaco.domain.WritingDateInfo;
import wonsoo.sfaco.domain.category.Category;
import wonsoo.sfaco.domain.user.User;

import javax.persistence.*;

@Entity
@Getter
public class BoardCommunity extends WritingDateInfo {  // 커뮤니티 게시판

    @Id
    @GeneratedValue
    @Column(name = "community_id")
    private Long id;  // 커뮤니티 글 ID

    private String title;  // 제목

    @Column(columnDefinition = "text")
    private String contents;  // 내용

    @ManyToOne
    @JoinColumn(name = "writer")
    private User user;  // 회원

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;  // 카테고리

}
