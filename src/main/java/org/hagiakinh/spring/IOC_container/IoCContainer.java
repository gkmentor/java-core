package org.hagiakinh.spring.IOC_container;

import java.util.HashMap;
import java.util.Map;
import org.hagiakinh.spring.IOC_container.service.EmailService;
import org.hagiakinh.spring.IOC_container.service.PushNotificationService;
import org.hagiakinh.spring.IOC_container.service.Service;
import org.hagiakinh.spring.IOC_container.service.SmsService;

public class IoCContainer {

    private final Map<Class<?>, Object> classMap = new HashMap<>();

    public void register(Class<?> interfaceType, Class<?> implType) throws Exception {
        Object implInstance = implType.getDeclaredConstructor().newInstance();
        classMap.put(interfaceType, implInstance);
    }

    public <T> T getInstance(Class<T> interfaceType) {
        return interfaceType.cast(classMap.get(interfaceType));
    }

    public static void main(String[] args) throws Exception {
        IoCContainer container = new IoCContainer();

        container.register(Service.class, EmailService.class);
        container.register(SmsService.class, SmsService.class);
        container.register(PushNotificationService.class, PushNotificationService.class);

        Service emailService = container.getInstance(Service.class);
        Client client1 = new Client(emailService);
        client1.doSomething();

        Service smsService = container.getInstance(SmsService.class);
        Client client2 = new Client(smsService);
        client2.doSomething();

        Service pushService = container.getInstance(PushNotificationService.class);
        Client client3 = new Client(pushService);
        client3.doSomething();
    }
}