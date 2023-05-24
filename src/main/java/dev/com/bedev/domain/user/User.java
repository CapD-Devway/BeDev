package dev.com.bedev.domain.user;

import dev.com.bedev.domain.date.BaseTimeEntity;
import dev.com.bedev.domain.post.Post;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User extends BaseTimeEntity implements UserDetails {



    @Column(nullable = false)
    private String email;

    @Column
    private String picture;



    @Column(nullable = false)
    private String userName;

    @Id
    @Column(nullable = false)
    private String id;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }


}
