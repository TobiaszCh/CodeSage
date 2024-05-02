package com.educator.level;
import com.educator.subject.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Level {
    @Id
    private Long id;
    @ManyToOne
    private Subject subject;
}
