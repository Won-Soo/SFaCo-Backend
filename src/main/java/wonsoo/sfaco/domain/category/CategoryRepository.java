package wonsoo.sfaco.domain.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {

    private final EntityManager em;

    // 카테고리 아이디로 조회
    public Category findById(Long id) {
        return em.find(Category.class, id);
    }

    // 카테고리 이름으로 조회
    public List<Category> findByName(String name) {
        return em.createQuery("select c from Category c where c.name = :name", Category.class).getResultList();
    }

    // 카테고리 전체 조회
    public List<Category> findAll() {
        return em.createQuery("select c from Category c", Category.class).getResultList();
    }
}
