package com.educator.dev.init;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@DependsOn("subjectDataInitializer")
@ConditionalOnProperty(prefix = "dev", name = "data.init", havingValue = "true")
public class LevelDataInitializer {


}
