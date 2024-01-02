//package com.kylemanagement.config.filters;
//
//import com.kylemanagement.config.security.UserDetailsImpl;
//import com.kylemanagement.model.User;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import java.io.IOException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import static java.util.Objects.nonNull;
//
//public class SessionAuthenticationFilter  extends OncePerRequestFilter
//{
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
//
//
//        if (nonNull(user)) {
//            UserDetailsImpl userDetails = UserDetailsImpl.build(user);
//
//            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());
//
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//}
