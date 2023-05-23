package dev.com.bedev.api.filter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import dev.com.bedev.api.user.service.UserService;
import dev.com.bedev.api.util.RequestUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.NoSuchElementException;

@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private final UserService userService;
    private final FirebaseAuth firebaseAuth;

    public JwtFilter(UserService userService, FirebaseAuth firebaseAuth) {
        this.userService = userService;
        this.firebaseAuth = firebaseAuth;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        FirebaseToken decodedToken;
        try{
            String header = RequestUtil.getAuthorizationToken(request.getHeader("Authorization"));
            decodedToken = firebaseAuth.verifyIdToken(header);
        } catch (FirebaseAuthException | IllegalArgumentException e) {
            response.setStatus(HttpStatus.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"code\":\"INVALID_TOKEN\", \"message\":\"" + e.getMessage() + "\"}");
            return;
        }


        try{
            userService.register(decodedToken.getUid(),decodedToken.getEmail(),decodedToken.getPicture(),decodedToken.getName());

        } catch(NoSuchElementException e){
            UserDetails user = userService.loadUserByUsername(decodedToken.getUid());
            response.setStatus(HttpStatus.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"code\":\"USER_NOT_FOUND\"}");
            response.getWriter().write(String.valueOf(user));
            response.getWriter().write(decodedToken.getEmail());
            return;
        }
        filterChain.doFilter(request, response);
    }
}