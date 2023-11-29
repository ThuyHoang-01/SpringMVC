package vn.edu.iuh.backend.ids;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Job_SkillID implements Serializable {
    private Long job;
    private Long skill;
}
