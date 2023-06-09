package dev.com.bedev.api.filter;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthFilterContainer {

    private OncePerRequestFilter authFilter;

    public void setAuthFilter(OncePerRequestFilter authFilter) {
        this.authFilter = authFilter;
    }

    public OncePerRequestFilter getFilter() {
        return authFilter;
    }
}