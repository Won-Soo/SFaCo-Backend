package wonsoo.sfaco.domain.boardcodi;

import lombok.Getter;
import wonsoo.sfaco.domain.WritingDateInfo;
import wonsoo.sfaco.domain.category.Category;
import wonsoo.sfaco.domain.user.User;

import javax.persistence.*;

@Entity
@Getter
public class BoardCodi extends WritingDateInfo {  // 코디 게시판

    @Id
    @GeneratedValue
    @Column(name = "codi_id")
    private Long id;  // 코디 글 ID

    private String title;  // 제목
    private String subtitle;  // 부제목
    private String model;  // 모델

    @Column(columnDefinition = "char(1)")
    @Enumerated(EnumType.STRING)
    private Gender gender;  // 성별

    private String fileName;  // 첨부파일명
    private String modifier;  // 수정자

    private User user;  // 회원
    private Category category;  // 카테고리

}
