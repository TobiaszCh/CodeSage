package com.educator.dev.init;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("development")
@DependsOn("subjectDataInitializer")
@AllArgsConstructor
public class LevelDataInitializer {


}
