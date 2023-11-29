package vn.edu.iuh.backend.ids;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Candidate_SkillID implements Serializable {
    private Long candidate;
    private Long skill;
}
