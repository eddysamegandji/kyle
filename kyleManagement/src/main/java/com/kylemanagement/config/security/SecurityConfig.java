package com.kylemanagement.config.security;

//import com.kylemanagement.config.filters.SessionAuthenticationFilter;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@ComponentScan(
        basePackages={"com.kylemanagement.config"}
)
public class SecurityConfig {

    @Resource
    UserDetailsServiceImpl userDetailService;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

//    @Bean
//    public SessionAuthenticationFilter sessionFilter() {
//        return new SessionAuthenticationFilter();
//    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable());
//        setMaxSessionToOnePerUserDiscardingOldOnes(http, sessionRegistry);
        configureExpressionUrlAuthorization(http);
        http.formLogin(formLogin -> formLogin
                .defaultSuccessUrl("http://localhost:8080/"));
        http.userDetailsService(userDetailService);
        return http.build();
    }

//    @Bean
//    public SessionRegistry sessionRegistry() {
//        return new SessionRegistryImpl();
//    }


    private void configureExpressionUrlAuthorization(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(c -> c
                .requestMatchers("/").permitAll()
                .requestMatchers("/login").permitAll()
                .anyRequest().authenticated()
        );
    }

//    private void setMaxSessionToOnePerUserDiscardingOldOnes(HttpSecurity http, SessionRegistry sessionRegistry) throws Exception {
//        http.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .maximumSessions(1)
//                .maxSessionsPreventsLogin(false)
//                .sessionRegistry(sessionRegistry)
//                .expiredUrl("/login"));
//    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
