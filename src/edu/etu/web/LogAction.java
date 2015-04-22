package edu.etu.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by korkota on 4/22/15.
 */
@WebFilter(filterName = "LogAction")
public class LogAction implements Filter {
    private ServletContext context;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpServletRequest httpReq = (HttpServletRequest) req;
        String ip = httpReq.getRemoteAddr();
        String uri = httpReq.getRequestURI();

        String username =  httpReq.getUserPrincipal().getName();

        StringBuffer buffer = new StringBuffer();
        buffer.append("User action.\n");
        buffer.append("  User: " + username);
        buffer.append(", ip: " + ip);
        buffer.append(", uri: \"" + uri + "\"");
        buffer.append(", method: " + httpReq.getMethod());

        Enumeration<String> requestParameters = req.getParameterNames();
        while (requestParameters.hasMoreElements()) {
            String paramName = (String) requestParameters.nextElement();
            buffer.append("\n  Request paramter name: " + paramName
                    + ", value: " + req.getParameter(paramName));
        }

        context.log(buffer.toString());

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        context = config.getServletContext();
    }

}
