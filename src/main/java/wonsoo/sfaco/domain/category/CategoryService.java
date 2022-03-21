package wonsoo.sfaco.domain.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * 카테고리 조회
     */
    // 전체 조회
    public List<Category> findCategories() {
        return categoryRepository.findAll();
    }

    // 단 건 조회
    public Category findOne(Long categoryId) {
        return categoryRepository.findOne(categoryId);
    }

    // 카테고리 이름으로 조회
    public Category findByName(String name) {
        return categoryRepository.findByName(name).orElse(null);
    }
}
