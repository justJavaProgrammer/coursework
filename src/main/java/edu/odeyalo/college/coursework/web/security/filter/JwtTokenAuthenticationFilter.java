package edu.odeyalo.college.coursework.web.security.filter;


import edu.odeyalo.college.coursework.support.jwt.JwtTokenProvider;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Map;

@Component
public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {
    public static final String BEARER = "Bearer ";
    private final JwtTokenProvider provider;
    private final UserDetailsService userDetailsService;

    public JwtTokenAuthenticationFilter(JwtTokenProvider provider, UserDetailsService userDetailsService) {
        this.provider = provider;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwtToken = getJwtToken(request);
        if (jwtToken == null || !provider.isValid(jwtToken)) {
            filterChain.doFilter(request, response);
            return;
        }
        String username = getUsername(jwtToken);
        UserDetails details = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(details, details.getPassword(), details.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }

    private String getUsername(String jwtToken) {
        Map<String, Object> claims = provider.getClaims(jwtToken);
        return (String) claims.get("username");
    }

    private String getJwtToken(HttpServletRequest request) {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header == null || !header.startsWith(BEARER)) {
            return null;
        }
        return header.substring(7);
    }
}
