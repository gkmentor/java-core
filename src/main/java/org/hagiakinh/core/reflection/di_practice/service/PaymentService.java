package org.hagiakinh.core.reflection.di_practice.service;

import lombok.extern.slf4j.Slf4j;
import org.hagiakinh.core.reflection.di_practice.annotation.Component;

@Slf4j
@Component
public class PaymentService {

  public void doSomething() {
    log.info("Payment service does something");
  }
}
