package org.hagiakinh.spring.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    private String path;
    private String method;
    private String authorizationHeader;
    private String body;
}
