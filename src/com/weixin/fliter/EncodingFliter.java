package com.weixin.fliter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Liuqi
 * Date: 2016/11/5.
 */
public class EncodingFliter implements Filter {
    private static final String DEFAULT_ENCODING = "utf-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(DEFAULT_ENCODING);
        //System.out.println(servletRequest.getRemoteAddr() + "---------add---------");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String uri = httpServletRequest.getRequestURI();
        System.out.println("filter-----" + uri);
        filterChain.doFilter(servletRequest, servletResponse);
        /*if (uri.endsWith(".jsp")) {
            httpServletRequest.getRequestDispatcher(httpServletRequest.getRequestURI()).forward(servletRequest, servletResponse);
        } else if (uri.endsWith(".do")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
        }*/
        //servletResponse.get
        servletResponse.setCharacterEncoding(DEFAULT_ENCODING);
    }

    @Override
    public void destroy() {

    }
}
