package wonsoo.sfaco.domain.category;

import lombok.Getter;
import wonsoo.sfaco.domain.boardcodi.BoardCodi;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Category {  // 카테고리

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;  // 카테고리 ID

    private String name;  // 카테고리명

    @OneToMany(mappedBy = "category")
    private List<BoardCodi> codiList = new ArrayList<>();  // 코디 게시판

}
