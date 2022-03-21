package wonsoo.sfaco.domain.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryRepository {

    private final EntityManager em;

    // 카테고리 단 건 조회
    public Category findOne(Long id) {
        return em.find(Category.class, id);
    }

    // 카테고리 이름으로 조회
    public Optional<Category> findByName(String name) {
        List<Category> findCategoryList = em.createQuery("select c from Category c where c.name = :name", Category.class).setParameter("name", name).getResultList();
        return findCategoryList.stream().findFirst();
    }

    // 카테고리 전체 조회
    public List<Category> findAll() {
        return em.createQuery("select c from Category c", Category.class).getResultList();
    }
}
