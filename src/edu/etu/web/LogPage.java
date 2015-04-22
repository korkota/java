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
@WebFilter(filterName = "LogPage")
public class LogPage implements Filter {
    private ServletContext context;

    public LogPage() {}

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpServletRequest httpReq = (HttpServletRequest) req;
        String ip = httpReq.getRemoteAddr();
        String uri = httpReq.getRequestURI();
        String username = null;

        if (httpReq.getUserPrincipal() != null) {
            username = httpReq.getUserPrincipal().getName();
        }

        StringBuffer buffer = new StringBuffer();
        buffer.append("View page.\n");
        buffer.append("  ip: " + ip);
        buffer.append(", page: \"" + uri + ((httpReq.getQueryString() != null) ? "?" + httpReq.getQueryString() : "") + "\"");
        buffer.append(((username != null) ? ", user: " + username : ", user not authenticated. "));

        context.log(buffer.toString());

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        context = config.getServletContext();
    }
}
