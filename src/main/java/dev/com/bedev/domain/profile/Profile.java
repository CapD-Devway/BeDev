package dev.com.bedev.domain.profile;

import dev.com.bedev.domain.date.BaseTimeEntity;
import dev.com.bedev.domain.enums.DevelopmentPart;
import dev.com.bedev.domain.uploadfile.UploadFile;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Builder
public class Profile extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "uploadFile_id")
    private UploadFile image;

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
