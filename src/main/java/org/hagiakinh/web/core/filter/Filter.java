package org.hagiakinh.web.core.filter;

import org.hagiakinh.web.core.model.Request;
import org.hagiakinh.web.core.model.Response;

public interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}
