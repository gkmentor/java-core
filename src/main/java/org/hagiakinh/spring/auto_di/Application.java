package org.hagiakinh.spring.auto_di;


import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.hagiakinh.spring.auto_di.annotation.Autowired;
import org.hagiakinh.spring.auto_di.annotation.Component;
import org.hagiakinh.spring.auto_di.loader.ContextLoader;
import org.hagiakinh.spring.auto_di.loader.Runner;
import org.hagiakinh.spring.auto_di.service.OrderService;
import org.hagiakinh.spring.auto_di.service.RestaurantService;

@Slf4j
@Component
public class Application implements Runner {

  @Autowired
  private OrderService orderService;

  public static void main(String[] args) {
    ContextLoader.getInstance().load("org.hagiakinh.spring.auto_di");
    keepApplicationRunning();
  }

  @Override
  public void run() {
    log.info("Application ready to start");

    orderService.makeOrder();

    val restaurantService = ContextLoader.getInstance().getBean(RestaurantService.class);
    restaurantService.logToday();
  }

  private static void keepApplicationRunning() {
    log.info("Server is running. Press Ctrl+C to exit.");
    try {
      while (true) {
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      log.error("Application interrupted. Shutting down.", e);
      Thread.currentThread().interrupt();
    }
  }
}
