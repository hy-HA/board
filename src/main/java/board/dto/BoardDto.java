package board.dto;

import board.domain.Board;
import board.domain.Reply;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String writer;
    private String title;
    private String content;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Board toEntity(){
        Board build = Board.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .build();
        return build;
    }

    @Builder
    public BoardDto(Board board){
        this.id = board.getId();
        this.writer = board.getWriter();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.createdDate = board.getCreatedDate();
    }
}
