package vn.edu.iuh.backend.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.backend.enums.SkillLevel;
import vn.edu.iuh.backend.ids.Job_SkillID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "job_skill")
@IdClass(Job_SkillID.class)
public class Job_skill {
    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
    @Column(name = "more_infos",length = 1000, nullable = false)
    private String more_info;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "skill_level", nullable = false)
    private SkillLevel skill_level;

}