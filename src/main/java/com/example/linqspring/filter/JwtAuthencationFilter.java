package com.example.linqspring.filter;

import org.springframework.stereotype.Component;
import org.springframework.util.*;
import com.example.linqspring.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtAuthencationFilter extends OncePerRequestFilter {
    
    @Autowired private JwtProvider jwtProvider;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException{   
        try{
            String token = parseBearerToken(request);

            if(token != null && !token.equalsIgnoreCase("null")){
                String userId = jwtProvider.validate(token);

                AbstractAuthenticationToken authentication
                        = new UsernamePasswordAuthenticationToken(userId,null, AuthorityUtils.NO_AUTHORITIES);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
                securityContext.setAuthentication(authentication);
                SecurityContextHolder.setContext(securityContext);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
       filterChain.doFilter(request,response);
    }
    private String parseBearerToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer "))
            return bearerToken.substring(7);
        return null;
    }
}
