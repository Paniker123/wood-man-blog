package com.woodman.woodmanblog.security;

import com.woodman.woodmanblog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final String HEADER_AUTHORIZATION = "Authorization";

    @Autowired
    private JwtTokenProvider mTokenProvider;

    @Autowired
    private UserService mUserService;

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        var jwt = getJwtFromRequest(request);
        var validationJwt = mTokenProvider.validateToken(jwt);

        if (StringUtils.hasText(jwt) && validationJwt.isValid()) {
            var userId = mTokenProvider.getUserIdFromJWT(jwt);
            var userDetails = mUserService.loggingById(userId);
            var authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authentication);

        } else {
            logger.error(validationJwt.getMessage());
        }

        filterChain.doFilter(request,response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        var bearerToken = request.getHeader(HEADER_AUTHORIZATION);
        if (bearerToken == null || !(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")))
            return null;
        return bearerToken.substring(7);
    }
}
