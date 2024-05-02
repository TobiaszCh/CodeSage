package com.educator.level;

import com.educator.subject.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("development")
@DependsOn("subjectDataInitializer")
@AllArgsConstructor
public class LevelDataInitializer {

    private final LevelRepository levelRepository;

    private final SubjectRepository subjectRepository;
    @PostConstruct
    public void initializeLevelData () {
        levelRepository.save(new Level(33L, subjectRepository.getById(9L)));

    }

}
