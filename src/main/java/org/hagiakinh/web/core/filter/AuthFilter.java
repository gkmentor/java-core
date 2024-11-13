package org.hagiakinh.web.core.filter;

import org.hagiakinh.web.core.model.Request;
import org.hagiakinh.web.core.model.Response;

public class AuthFilter implements Filter{

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
//        if ("/home".equals(request.getPath())) {
//            chain.doFilter(request, response);
//        } else {
//            response.write("403 - Forbidden");
//        }
    }
}
