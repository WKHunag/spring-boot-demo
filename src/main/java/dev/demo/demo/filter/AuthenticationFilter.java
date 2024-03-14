package dev.demo.demo.filter;

import com.google.common.hash.Hashing;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AuthenticationFilter implements Filter {
    private static final String key = "Spring-Boot";
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // request
        StringBuilder sb = new StringBuilder(); //It is easier to combine string with this data type than String.
        BufferedReader reader = servletRequest.getReader(); //The reader is for reading HttpRequest
        String line;
        while ((line = reader.readLine()) != null) { //Reading line by line until there are nothing remained.
            sb.append(line);
        }

        String RequestBody = sb.toString();

        String sha256hex = Hashing.sha256()
                .hashString(key+RequestBody, StandardCharsets.UTF_8)
                .toString();

        if (!sha256hex.equals(((HttpServletRequest)servletRequest).getHeader("Authentication"))) {
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
