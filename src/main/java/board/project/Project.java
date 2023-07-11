package board.project;

import board.TimeEntity;
import board.member.Member;
import board.study.Study;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Where(clause = "is_deleted = false")
public class Project extends TimeEntity {

    @Id @GeneratedValue
    private Long id;

    private String title;

    private String startdate;

    @ManyToOne
    @JoinColumn(name = "study_id")
    private Study study;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public static Project of(String title, String startdate, Study study, Member member){
        Project project = new Project();
        project.title = title;
        project.startdate = startdate;
        project.study = study;
        project.member = member;
        return project;
    }

    public String getStudy(){
        return study.getStudyType();
    }
    public String userName(){
        return member.getUsername();
    }
}