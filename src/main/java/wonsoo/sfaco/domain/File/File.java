package wonsoo.sfaco.domain.File;

import lombok.Getter;
import wonsoo.sfaco.domain.boardcodi.BoardCodi;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
public class File {

    @Id
    @GeneratedValue
    @Column(name = "file_id")
    private Long id;  // 파일 ID

    private String originFilename;  // 기존 파일명
    private String storeFilename;  // 저장 파일명

    @OneToOne(mappedBy = "file", fetch = LAZY)
    private BoardCodi boardCodi;  // 코디 게시판
}