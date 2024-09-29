package org.hagiakinh.core.reflection.dynamic_proxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Định nghĩa annotation @Loggable
@Retention(RetentionPolicy.RUNTIME)  // Annotation có thể sử dụng tại runtime
@Target(ElementType.METHOD)  // Annotation này chỉ áp dụng cho phương thức
public @interface Loggable {
    String value() default "Executing method";  // Thuộc tính của annotation với giá trị mặc định
}