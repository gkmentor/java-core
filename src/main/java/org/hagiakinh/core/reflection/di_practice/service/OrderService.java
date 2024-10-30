package org.hagiakinh.core.reflection.di_practice.service;

import lombok.extern.slf4j.Slf4j;
import org.hagiakinh.core.reflection.di_practice.annotation.Autowire;
import org.hagiakinh.core.reflection.di_practice.annotation.Service;
import org.hagiakinh.core.reflection.di_practice.annotation.PostConstruct;

@Slf4j
@Service
public class OrderService {

  @Autowire
  private PaymentService paymentService;

  @Autowire
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
