package wonsoo.sfaco.domain.boardcommunity;

import lombok.Getter;
import wonsoo.sfaco.domain.category.Category;
import wonsoo.sfaco.domain.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class BoardCommunity {  // 커뮤니티 게시판

    @Id
    @GeneratedValue
    @Column(name = "community_id")
    private Long id;  // 커뮤니티 글 ID

    private String title;  // 제목

    @Column(columnDefinition = "text")
    private String contents;  // 내용

    private LocalDateTime createdAt;  // 작성일자
    private LocalDateTime modifiedAt;  // 수정일자
    private LocalDateTime deletedAt;  // 삭제일자

    private User user;  // 회원
    private Category category;  // 카테고리

}
