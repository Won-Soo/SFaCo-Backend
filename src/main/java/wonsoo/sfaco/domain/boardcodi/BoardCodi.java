package wonsoo.sfaco.domain.boardcodi;

import lombok.Getter;
import wonsoo.sfaco.domain.File.File;
import wonsoo.sfaco.domain.WritingDateInfo;
import wonsoo.sfaco.domain.category.Category;
import wonsoo.sfaco.domain.clothing.Clothing;
import wonsoo.sfaco.domain.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

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

    private String modifier;  // 수정자

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "writer")
    private User user;  // 회원

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "category_id")
    private Category category;  // 카테고리

    @OneToMany(mappedBy = "boardCodi", cascade = ALL)
    private List<Clothing> clothingList = new ArrayList<>();  // 의상

    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "file_id")
    private File file;  // 파일

}
