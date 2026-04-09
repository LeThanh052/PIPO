package com.pipo.backend.domain;

import com.pipo.backend.domain.User;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "issue_activities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IssueActivity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_id")
    private Issue issue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "action_type", length = 50)
    private String actionType;

    @Column(name = "old_value", columnDefinition = "TEXT")
    private String oldValue;

    @Column(name = "new_value", columnDefinition = "TEXT")
    private String newValue;
}
