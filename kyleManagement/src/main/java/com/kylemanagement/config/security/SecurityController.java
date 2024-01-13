package com.kylemanagement.config.security;

import com.api.handler.AuthResourceApi;
import com.api.model.LoginResponseApi;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class SecurityController implements AuthResourceApi {

    final AuthenticationManager authenticationManager;
    final JwtEncoder jwtEncoder;
    @Value("${jwt.expiration:600}")
    private Integer tokenExpiration;

    @GetMapping("profile")
    public Authentication authentication(Authentication authentication) {
        return authentication;
    }

    @Override
    public ResponseEntity<LoginResponseApi> login(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        String scope = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        Instant instant = Instant.now();

        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .issuedAt(instant)
                .expiresAt(instant.plus(tokenExpiration, ChronoUnit.SECONDS))
                .subject(username)
                .claim("scope", scope)
                .build();

        JwtEncoderParameters jwtEncoderParameters = JwtEncoderParameters.from(
                JwsHeader.with(MacAlgorithm.HS512).build(),
                jwtClaimsSet
        );

        String jwt = jwtEncoder.encode(jwtEncoderParameters).getTokenValue();
        LoginResponseApi loginResponseApi = new LoginResponseApi();
        loginResponseApi.setIsAuthenticated(true);
        loginResponseApi.setAccessToken(jwt);
        loginResponseApi.setUsername(username);
        loginResponseApi.setRoles(scope);
        return ok(loginResponseApi);
    }
}
