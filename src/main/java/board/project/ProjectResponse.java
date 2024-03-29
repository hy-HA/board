package board.project;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProjectResponse {
    @Schema(description = "아이디", example = "1")
    private Long id;
    @Schema(description = "제목", example = "런닝 1회차")
    private String title;
    @Schema(description = "시작날짜", example = "2023-07-02")
    private String startDate;

    @Schema(description = "스터디", example = "sports")
    private Long study_id;

    @Schema(description = "유저네임", example = "홍길동")
    private String userName;
    @Schema(description = "북마크", example = "200")
    private int bookmark;

    public ProjectResponse(Project project){
        this.id = project.getId();
        this.startDate= project.getStartDate();
        this.title = project.getTitle();
        this.study_id = project.getStudyId();
        this.userName = project.userName();
        this.bookmark = project.getBookmark();
    }

}
