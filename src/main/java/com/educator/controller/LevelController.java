package com.educator.controller;
import com.educator.core.level.Level;
import com.educator.core.level.LevelDto;
import com.educator.core.level.LevelService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/levels")
public class LevelController {

    private final LevelService levelService;
    @GetMapping
    public List<LevelDto> getAllLevel() {
        return levelService.getAllLevel();
    }
    @PostMapping
    public void createLevel(@RequestBody Level level) {
        levelService.createLevel(level);
    }
    @DeleteMapping("/{id}")
    public void deleteLevel(@PathVariable Long id) {
        levelService.deleteLevel(id);
    }
}
