package org.hagiakinh.spring.auto_di.service;

import lombok.extern.slf4j.Slf4j;
import org.hagiakinh.spring.auto_di.annotation.Service;

@Slf4j
@Service
public class PaymentService {

  public void doSomething() {
    log.info("Payment service does something");
  }
}
