package com.kylemanagement.config.security;

import com.api.handler.AuthResourceApi;
import com.api.model.LoginResponseApi;
import jakarta.annotation.Resource;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class SecurityController implements AuthResourceApi {

    final AuthenticationManager authenticationManager;
    final JwtEncoder jwtEncoder;
    @Resource
    UserDetailsServiceImpl userDetailsService;
    final JWTTokenUtil jwtTokenUtil;

    @GetMapping("profile")
    public Authentication authentication(Authentication authentication) {
        return authentication;
    }

    @Override
    public ResponseEntity<LoginResponseApi> login(String username, String password) {
        try {
            authenticate(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        final String token = jwtTokenUtil.generateToken(userDetails);
        final String refreshToken = jwtTokenUtil.generateRefreshToken(userDetails);

        LoginResponseApi loginResponseApi = new LoginResponseApi();
        loginResponseApi.setIsAuthenticated(true);
        loginResponseApi.setAccessToken(token);
        loginResponseApi.setRefreshToken(refreshToken);
        loginResponseApi.setUsername(username);
        loginResponseApi.setRoles(userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" ")));
        return ok(loginResponseApi);
    }

    private void authenticate(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new DisabledException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("INVALID_CREDENTIALS", e);
        }
    }
}
