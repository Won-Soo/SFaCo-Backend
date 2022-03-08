package wonsoo.sfaco.domain.category;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Category {  // 카테고리

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;  // 카테고리 ID

    private String name;  // 카테고리명

}
