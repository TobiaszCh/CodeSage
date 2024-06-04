package com.educator.core.level;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class LevelService {

    private final LevelMapper levelMapper;
    private final LevelRepository levelRepository;

    public List<LevelDto> getAllLevel() {
        return levelMapper.mapToListDtoLevel(levelRepository.findAll());
    }

    public void createLevel(Level level) {
        levelRepository.save(level);
    }

    public void deleteLevel(Long id) {
        levelRepository.deleteById(id);
    }
}
