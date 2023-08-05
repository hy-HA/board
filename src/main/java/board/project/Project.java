package board.project;

import board.BaseEntity;
import board.member.Member;
import board.study.Study;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "project")
//@Audited(targetAuditMode = NOT_AUDITED)
//@AuditOverride(forClass= BaseEntity.class)
@NoArgsConstructor
@Where(clause = "is_deleted = false")
public class Project extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "project_id")
    private Long id;

    private String title;

    private String startdate;

    private int bookmark;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "study_id")
    private Study study;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

    public Long getStudyId(){
        return study.getId();
    }
    public String userName(){
        return member.getUsername();
    }

    public int getBookmark(){
        return this.bookmark;
    }

    public void updateProject(String title, String startdate) {
        this.title = title;
        this.startdate = startdate;
    }
}
