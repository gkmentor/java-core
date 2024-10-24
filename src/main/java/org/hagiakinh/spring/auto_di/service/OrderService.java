package org.hagiakinh.spring.auto_di.service;

import lombok.extern.slf4j.Slf4j;
import org.hagiakinh.spring.auto_di.annotation.Autowired;
import org.hagiakinh.spring.auto_di.annotation.Service;
import org.hagiakinh.spring.auto_di.annotation.PostConstruct;

@Slf4j
@Service
public class OrderService {

  @Autowired
  private PaymentService paymentService;

  @Autowired
  private RestaurantService restaurantService;
  private String NUMBER = "1";

  @PostConstruct
  void postInitiate() {
    log.info("Do something after creating orderService instance");
  }

  public void makeOrder() {
    paymentService.doSomething();
    restaurantService.doSomething();
  }
}
