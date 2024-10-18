package org.hagiakinh.spring.auto_di.service;

import lombok.extern.slf4j.Slf4j;
import org.hagiakinh.spring.auto_di.annotation.Autowired;
import org.hagiakinh.spring.auto_di.annotation.Component;
import org.hagiakinh.spring.auto_di.annotation.PostConstruct;

@Slf4j
@Component
public class OrderService {

  @Autowired
  private PaymentService paymentService;

  @Autowired
  private RestaurantService restaurantService;

  @PostConstruct
  void postInitiate() {
    log.info("Do something after creating orderService instance");
  }

  public void makeOrder() {
    paymentService.doSomething();
    restaurantService.doSomething();
  }
}
