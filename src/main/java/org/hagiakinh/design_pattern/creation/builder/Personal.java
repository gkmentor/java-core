package org.hagiakinh.design_pattern.creation.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Personal {
	private String name;
    private Integer age;
}
