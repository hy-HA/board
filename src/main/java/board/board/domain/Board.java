package board.board.domain;

import board.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "board")
//@Audited
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 10, nullable = false)
    private String writer;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Reply> replyList;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;


    @Builder
    public Board(Long id, String title, String content, String writer){
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }




}
