package com.marocair.marocair;

import com.marocair.marocair.controller.Auth;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/*")
public class Filter implements jakarta.servlet.Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        String url = ((HttpServletRequest)req).getRequestURL().toString();

        System.out.println("Asked for: "+url);

        if (url.contains("auth")) { // should be fixed.../!\
            filterChain.doFilter(req, resp); //sends request to next resource
            return;
        }

        if (Auth.auth(((HttpServletRequest) req).getSession()) == null) {
            HttpServletResponse httpResponse = (HttpServletResponse) resp;
            httpResponse.sendRedirect("http://localhost:8080/marocair_war_exploded/auth/login.jsp");
            System.out.println("Unauthorized....");
            return;
        }

        filterChain.doFilter(req, resp); //sends request to next resource

    }
}
