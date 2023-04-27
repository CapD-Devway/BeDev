package dev.com.bedev.domain.profile;

import dev.com.bedev.domain.date.BaseTimeEntity;
import dev.com.bedev.domain.enums.DevelopmentPart;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Profile extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String schoolId;

    @Column(nullable = false)
    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Set<DevelopmentPart> developmentPart;

    @Column(nullable = false)
    private String developTool;

    @Column(nullable = false)
    private String introduce;

    @Column(nullable = false)
    private String name;





}
