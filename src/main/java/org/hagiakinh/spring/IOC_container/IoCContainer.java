package org.hagiakinh.spring.IOC_container;

import java.util.HashMap;
import java.util.Map;

public class IoCContainer {

    private final Map<Class<?>, Object> classMap = new HashMap<>();

    public void register(Class<?> interfaceType, Class<?> implType) throws Exception {
        Object implInstance = implType.getDeclaredConstructor().newInstance();
        classMap.put(interfaceType, implInstance);
    }

    public <T> T getInstance(Class<T> interfaceType) {
        return interfaceType.cast(classMap.get(interfaceType));
    }

}