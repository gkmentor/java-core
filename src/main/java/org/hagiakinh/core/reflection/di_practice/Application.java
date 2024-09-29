package org.hagiakinh.core.reflection.di_practice;


import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.hagiakinh.core.reflection.di_practice.annotation.Autowire;
import org.hagiakinh.core.reflection.di_practice.annotation.Component;
import org.hagiakinh.core.reflection.di_practice.loader.ContextLoader;
import org.hagiakinh.core.reflection.di_practice.loader.Runner;
import org.hagiakinh.core.reflection.di_practice.service.OrderService;
import org.hagiakinh.core.reflection.di_practice.service.RestaurantService;

@Slf4j
@Component
public class Application implements Runner {

  @Autowire
  private OrderService orderService;

  public static void main(String[] args) {
    ContextLoader.getInstance().load("org.hagiakinh.core.reflection.di_practice");
  }

  @Override
  public void run() {
    log.info("Application ready to start");

    orderService.makeOrder();

    val restaurantService = ContextLoader.getInstance().getBean(RestaurantService.class);
    restaurantService.logToday();
  }
}
