package org.hagiakinh.web.core.dispatcher;

import lombok.extern.slf4j.Slf4j;
import org.hagiakinh.web.core.filter.AuthFilter;
import org.hagiakinh.web.core.filter.Filter;
import org.hagiakinh.web.core.filter.FilterChain;
import org.hagiakinh.web.core.model.Request;
import org.hagiakinh.web.core.model.Response;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Dispatcher {

    private final Map<String, RequestHandler> routeHandlers = new HashMap<>();
    private final FilterChain filterChain = new FilterChain();


    public Dispatcher() {
        loadConfig();
    }

    private void loadConfig() {
        try {
            File configFile = new File("src/main/resources/web/core/config.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(configFile);
            doc.getDocumentElement().normalize();

            NodeList routeList = doc.getElementsByTagName("route");
            for (int i = 0; i < routeList.getLength(); i++) {
                String path = doc.getElementsByTagName("path").item(i).getTextContent();
                String handlerClass = doc.getElementsByTagName("handler").item(i).getTextContent();

                Class<?> clazz = Class.forName(handlerClass);
                RequestHandler handler = (RequestHandler) clazz.getDeclaredConstructor().newInstance();
                routeHandlers.put(path, handler);
            }

            NodeList filterList = doc.getElementsByTagName("filter");
            for (int i = 0; i < filterList.getLength(); i++) {
                String filterClass = filterList.item(i).getTextContent();

                Class<?> clazz = Class.forName(filterClass);
                Filter filter = (Filter) clazz.getDeclaredConstructor().newInstance();
                filterChain.addFilter(filter);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public String dispatch(Request request) {
        Response response = new Response();

        filterChain.doFilter(request, response);
        filterChain.setIndex(0);

        if (response.getContent().isEmpty()) {
            RequestHandler handler = routeHandlers.get(request.getPath());
            if (handler != null) {
                response.write(handler.handle());
            } else {
                response.write("404 - Page Not Found");
            }
        }

        return response.getContent();
    }
}
