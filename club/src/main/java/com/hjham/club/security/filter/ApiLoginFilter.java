package com.hjham.club.security.filter;

import java.io.IOException;
import java.security.Principal;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.hjham.club.security.util.JWTUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ApiLoginFilter extends AbstractAuthenticationProcessingFilter{
  private JWTUtil jwtUtil;

  public ApiLoginFilter(String defaultFilterProcessUrl, JWTUtil jwtUtil) {
    super(defaultFilterProcessUrl);
    this.jwtUtil = jwtUtil;
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException, IOException, ServletException {
    log.info("======================= ApiLoginFilter.attemptAuthentication() =======================");
    String email = request.getParameter("email");
    String pw = "1234";

    log.info("email : " + email);
    log.info("pw : " + pw);
    // if(email == null) {
    //   throw new BadCredentialsException("email cannot be null");
    // }

    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, pw);
    Authentication authentication = getAuthenticationManager().authenticate(authenticationToken);
    log.info(authentication.getPrincipal());
    return authentication;
    // log.info(authenticationToken.getPrincipal());
    // return getAuthenticationManager().authenticate(authenticationToken);
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
      Authentication authResult) throws IOException, ServletException {
    log.info(authResult.getName());
    log.info(authResult); //principal
    String email = authResult.getName();

    try {
      String token = jwtUtil.generateToken(email);
      response.setContentType("text/plain");
      response.getOutputStream().write(token.getBytes());
      log.info("==================== api login success ====================");
      log.info("token info :: " + token);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
    


  
}
