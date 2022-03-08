package wonsoo.sfaco.domain;

import lombok.Getter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public abstract class WritingDateInfo {  // 글의 일자 정보

    private LocalDateTime createdAt;  // 작성일자
    private LocalDateTime modifiedAt;  // 수정일자
    private LocalDateTime deletedAt;  // 삭제일자

}
