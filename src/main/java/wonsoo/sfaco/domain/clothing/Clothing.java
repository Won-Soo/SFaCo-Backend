package wonsoo.sfaco.domain.clothing;

import lombok.Getter;
import wonsoo.sfaco.domain.boardcodi.BoardCodi;

import javax.persistence.*;

@Entity
@Getter
public class Clothing {  // 의상

    @Id
    @GeneratedValue
    @Column(name = "clothing_id")
    private Long id;  // 의상 ID

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ClothingType clothingType;  // 의상 종류

    private String name;  // 의상명
    private int price;  // 가격

    @Column(columnDefinition = "text")
    private String site;  // 구매처

    @ManyToOne
    @JoinColumn(name = "codi_id")
    private BoardCodi boardCodi;  // 코디 게시판

}
