package com.konasl.livescore.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.konasl.livescore.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Component
public class AuthAccessDeniedHandler implements AccessDeniedHandler {
//TODO test
    @Override
    public void handle(final HttpServletRequest request, final HttpServletResponse response, final AccessDeniedException accessDeniedException) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        OutputStream out = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(out,
                ErrorResponse.builder()
                        .code(HttpStatus.FORBIDDEN.name())
                        .status(HttpStatus.FORBIDDEN.value())
                        .message(accessDeniedException.getMessage())
                        .build()
        );
        out.flush();
    }
}