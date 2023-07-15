package board.study;

import board.SampleLogTest;
import board.exception.DomainException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudyService {

    private final StudyRepository studyRepository;
    private final SampleLogTest sampleLogTest;

    @Transactional
    public StudyResponse createStudy(StudyRequest request) {
        Study study = Study.builder()
                .study(request.getStudy())
                .build();

        studyRepository.save(study);
        sampleLogTest.testLog();

        return new StudyResponse(study);
    }

//    @Transactional
    public List<StudyResponse> readStudyList() {
        List<StudyResponse> responses = studyRepository.findAll().stream()
                .map(StudyResponse::new)
                .collect(Collectors.toList());

        return responses;
    }

    @Transactional
    public StudyResponse readStudy(Long id) {
        Study study = studyRepository.findById(id).orElseThrow(()-> DomainException.notFindRow(id));

        StudyResponse response = new StudyResponse(study);

        return response;
    }

    @Transactional
    public void deleteStudy(Long id) {
        Study study = studyRepository.findById(id).orElseThrow(()-> DomainException.notFindRow(id));

        study.delete();
    }

    public SBookmarkResponse getAverageBookmark(Long id) {
        Study study = studyRepository.findById(id).orElseThrow(()-> DomainException.notFindRow(id));
        return SBookmarkResponse.builder()
                .bookmark(study.getAverageBookmark())
                .studyType(study.getStudyType())
                .build();
    }
}
