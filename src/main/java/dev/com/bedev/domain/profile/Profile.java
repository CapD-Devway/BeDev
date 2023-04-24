package dev.com.bedev.domain.profile;

import dev.com.bedev.domain.date.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;


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

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String developmentPart;

    @Column(nullable = false)
    private String developTool;

    @Column(nullable = false)
    private String introduce;

    @Column(nullable = false)
    private String name;


    @Column
    private String content;



}
