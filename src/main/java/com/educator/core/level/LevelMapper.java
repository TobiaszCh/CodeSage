package com.educator.core.level;
import com.educator.core.answer_session.AnswerSessionRepository;
import com.educator.core.subject.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class LevelMapper {

    private final SubjectRepository subjectRepository;
    private final AnswerSessionRepository answerSessionRepository;

    public LevelDto mapToDtoLevel(Level level) {
        return new LevelDto(level.getId());
    }

    public Level mapToLevel(LevelDto levelDto) {
        return new Level(levelDto.getId());
    }

    public List<LevelDto> mapToListDtoLevel(List<Level> levels) {
        return levels.stream().map(this::mapToDtoLevel).collect(Collectors.toList());
    }
}
