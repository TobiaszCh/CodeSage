package com.educator.dev.init;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Profile("development")
@DependsOn("subjectDataInitializer")
public class LevelDataInitializer {


}
