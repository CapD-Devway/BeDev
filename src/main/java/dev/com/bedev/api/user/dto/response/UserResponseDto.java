package dev.com.bedev.api.user.dto.response;

import dev.com.bedev.domain.user.User;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserResponseDto {
    private String uid;
    private String email;
    private String nickname;

    public static UserResponseDto from(User user) {
        return UserResponseDto.builder()
                .email(user.getEmail())
                .uid(user.getUsername())
                .nickname(user.getNickname())
                .build();
    }
}
