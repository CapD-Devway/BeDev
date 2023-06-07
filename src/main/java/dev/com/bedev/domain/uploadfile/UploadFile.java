package dev.com.bedev.domain.uploadfile;

import dev.com.bedev.domain.profile.Profile;
import dev.com.bedev.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UploadFile {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String imageUrl;

    @Column
    private String downloadUrl;

    @Column
    private long file_size;

    @OneToOne(mappedBy = "image")
    private Profile profile;

}
