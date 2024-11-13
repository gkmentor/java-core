package org.hagiakinh.web.core.filter;

import lombok.Setter;
import org.hagiakinh.web.core.model.Request;
import org.hagiakinh.web.core.model.Response;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {

    private final List<Filter> filters = new ArrayList<>();
    @Setter
    private int index = 0;

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void doFilter(Request request, Response response) {
        if (index < filters.size()) {
            Filter currentFilter = filters.get(index++);
            currentFilter.doFilter(request, response, this);
        }
    }
}
