package org.hagiakinh.web.core.dispatcher;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Dispatcher {

    private Map<String, RequestHandler> routeHandlers = new HashMap<>();

    public Dispatcher() {
        loadConfig("src/main/resources/web/core/config.xml");
    }

    // Phương thức đọc cấu hình từ XML và tạo các handler
    private void loadConfig(String configPath) {
        try {
            File configFile = new File(configPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(configFile);
            doc.getDocumentElement().normalize();

            NodeList routeList = doc.getElementsByTagName("route");
            for (int i = 0; i < routeList.getLength(); i++) {
                String path = doc.getElementsByTagName("path").item(i).getTextContent();
                String handlerClass = doc.getElementsByTagName("handler").item(i).getTextContent();

                // Tạo một instance của lớp handler và lưu vào map
                Class<?> clazz = Class.forName(handlerClass);
                RequestHandler handler = (RequestHandler) clazz.getDeclaredConstructor().newInstance();
                routeHandlers.put(path, handler);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Phương thức xử lý yêu cầu
    public String dispatch(String path) {
        RequestHandler handler = routeHandlers.get(path);
        if (handler != null) {
            return handler.handle();
        } else {
            return "404 - Page Not Found";
        }
    }
}
