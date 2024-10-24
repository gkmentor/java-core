package org.hagiakinh.spring.auto_di.loader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.hagiakinh.spring.auto_di.annotation.Autowired;
import org.hagiakinh.spring.auto_di.annotation.Service;
import org.hagiakinh.spring.auto_di.annotation.PostConstruct;
import org.reflections.Reflections;

@Slf4j
public class ContextLoader {

  private static final ContextLoader INSTANCE = new ContextLoader();

  private final Map<String, Object> nameToInstance = new HashMap<>();

  public static ContextLoader getInstance() {
    return INSTANCE;
  }

  private ContextLoader() {
  }

  public synchronized void load(String scanPackage) {
    val reflections = new Reflections(scanPackage); // load toàn bộ package
    val classes = reflections.getTypesAnnotatedWith(Service.class); // lấy toàn bộ class

    initiateInstance(classes);
    for (val entry : nameToInstance.entrySet()) {
      val instance = entry.getValue();
      injectFieldValue(instance);
      invokePostInitiate(instance);
    }
    executeRunner();
  }

  private void initiateInstance(Set<Class<?>> classes) {
    for (val clazz : classes) {
      try {
        val c = Class.forName(clazz.getName());
        val instance = c.getDeclaredConstructor().newInstance(); // khởi tạo
        nameToInstance.put(clazz.getName(), instance);
      } catch (Exception ex) {
        throw new RuntimeException("Cannot initialize new instance for " + clazz.getName());
      }
    }
  }

  private void executeRunner() {
    val runners = nameToInstance.values().stream()
        .filter(Runner.class::isInstance)
        .toList();

    if (runners.isEmpty()) {
      return;
    }

    if (runners.size() > 1) {
      throw new RuntimeException("Cannot have more than 1 runner class");
    }

    ((Runner) runners.getFirst()).run();
  }

  private static void invokePostInitiate(Object instance) {
    val postMethods = Arrays.stream(instance.getClass().getDeclaredMethods()).filter(
            method -> Arrays.stream(method.getDeclaredAnnotations())
                .anyMatch(a -> a.annotationType() == PostConstruct.class))
        .toList();
    if (postMethods.isEmpty()) {
      return;
    }
    if (postMethods.size() > 1) {
      throw new RuntimeException("Cannot have more than 1 post initiate method");
    }
    try {
      val method = postMethods.get(0);
      method.setAccessible(true);
      method.invoke(instance);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private void injectFieldValue(final Object instance) {
    val fields = instance.getClass().getDeclaredFields();
    Arrays.stream(fields)
        .filter(field -> Arrays.stream(field.getDeclaredAnnotations())
            .anyMatch(a -> a.annotationType() == Autowired.class))
        .forEach(field -> {
          val value = nameToInstance.get(field.getType().getName());
          field.setAccessible(true);
          try {
            field.set(instance, value);
          } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot inject dependency " + field.getClass().getName()
                + " to " + instance.getClass().getName());
          }
        });
  }


  @SuppressWarnings("unchecked")
  public <T> T getBean(Class<T> clazz) {
    return (T) nameToInstance.get(clazz.getName());
  }
}
