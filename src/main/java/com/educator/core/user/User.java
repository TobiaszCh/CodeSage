package com.educator.core.user;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@Entity(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private Long id;
    private String userName;
    private String achievements;
    private int points;

}
