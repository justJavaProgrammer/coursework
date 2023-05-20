package edu.odeyalo.college.coursework.support.jwt;

import edu.odeyalo.college.coursework.support.security.IdAwareUserDetails;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.SignatureException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

@Component
public class SecretKeyJwtTokenProvider implements JwtTokenProvider {
    private final String secretKey;
    private final Integer EXPIRATION_TIME_MS = 100000;
    private final Logger logger = LoggerFactory.getLogger(SecretKeyJwtTokenProvider.class);

    public SecretKeyJwtTokenProvider(@Value("${application.security.jwt.secret.key}") String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public String generateJwtToken(IdAwareUserDetails userDetails) {
        Map<String, Object> claims = Map.of(
                "id", userDetails.getId(),
                "username", userDetails.getUsername(),
                "authorities", userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList()
        );
        return doGenerateJwtToken(claims, userDetails.getUsername(), EXPIRATION_TIME_MS, SignatureAlgorithm.HS256, secretKey.getBytes());
    }

    @Override
    public Object getBody(String token) {
        return getParser().parse(token).getBody();
    }

    @Override
    public Map<String, Object> getClaims(String token) {
        return getParser().parseClaimsJws(token).getBody();
    }

    @Override
    public boolean isValid(String token) {
        try {
            getParser().parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            this.logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            this.logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            this.logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            this.logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

    protected JwtParser getParser() {
        return Jwts.parserBuilder().setSigningKey(secretKey.getBytes()).build();
    }

    protected String doGenerateJwtToken(Map<String, Object> claims,
                                        String subject,
                                        Integer expiredTime,
                                        SignatureAlgorithm algorithm,
                                        byte[] key) {
        return Jwts.builder().setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expiredTime * 1000L))
                .setSubject(subject)
                .signWith(algorithm, key)
                .compact();
    }
}
