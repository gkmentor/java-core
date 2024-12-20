package org.hagiakinh.spring.auto_di.service;

import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.hagiakinh.spring.auto_di.annotation.Service;

@Slf4j
@Service
public class RestaurantService {

  public void doSomething() {
    log.info("Restaurant service does something");
  }

  public void logToday() {
    log.info("Today: {}", Instant.now());
  }

}
