package com.pipo.backend.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

import com.pipo.backend.domain.User;

@Entity
@Table(name = "project_members")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectMember extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "joined_at", updatable = false)
    private LocalDateTime joinedAt;

    @Override
    @PrePersist
    public void handleBeforeCreate() {
        super.handleBeforeCreate();
        joinedAt = LocalDateTime.now();
    }
}
