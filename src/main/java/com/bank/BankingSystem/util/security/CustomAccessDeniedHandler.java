package com.bank.BankingSystem.util.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.bank.BankingSystem.exception.ErrorException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        ErrorException exception = new ErrorException();
        exception.setCode(HttpServletResponse.SC_FORBIDDEN);
        exception.setMessage(accessDeniedException.getLocalizedMessage());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_OK);
        var responseMap = new HashMap<String, Object>();
        responseMap.put("response", exception);
        OutputStream out = response.getOutputStream();
        new ObjectMapper().writeValue(out, responseMap);
        out.flush();
    }
}