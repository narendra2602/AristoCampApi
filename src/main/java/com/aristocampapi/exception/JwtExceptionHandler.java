package com.aristocampapi.exception;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.ContentCachingRequestWrapper;

import com.aristocampapi.response.CampApprovalStatusResponse;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;


import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@ControllerAdvice
public class JwtExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ExpiredJwtException.class, MalformedJwtException.class, SignatureException.class})
    protected ResponseEntity<Object> handleJwtExceptions(AuthenticationException ex) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        String message = "Invalid or expired token";

        return ResponseEntity.status(status).body(message);
    }

    @ExceptionHandler(value = {BadCredentialsException.class})
    protected ResponseEntity<Object> handleBadCredentialsException(BadCredentialsException ex,HttpServletRequest req) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        //String username = getUsernameFromSecurityContext();
       // System.out.println("request sis "+request.getRequest().toString());
        
        if (req instanceof ContentCachingRequestWrapper) {
            ContentCachingRequestWrapper wrapper = (ContentCachingRequestWrapper) req;
            System.out.println(new String(wrapper.getContentAsByteArray()));
          }
        else
        	System.out.println("kuch nahi hua ");
        //String reqBody = "your request body is " + new String(request.getContentAsByteArray(), StandardCharsets.UTF_8);
        //System.out.println(reqBody);
		CampApprovalStatusResponse res=new CampApprovalStatusResponse();
		 String message = "Invalid credentials or User is disabled";
		res.setId(0);
		res.setMessage(message);

      

//        return ResponseEntity.status(status).body(message);
        return ResponseEntity.status(status).body(res);
    }
    
    
    private String getUsernameFromRequestBody(HttpServletRequest request) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> requestBody = mapper.readValue(request.getInputStream(), Map.class);
            return (String) requestBody.get("username");
        } catch (IOException e) {
            // If there's an error parsing the request or the "username" key doesn't exist, return null
            return null;
        }
    }   
    private String getUsernameFromSecurityContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                return ((UserDetails) principal).getUsername();
            } else {
                return principal.toString();
            }
        }
        return "Anonymous";
    }
}