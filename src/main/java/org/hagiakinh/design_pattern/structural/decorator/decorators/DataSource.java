package org.hagiakinh.design_pattern.structural.decorator.decorators;

public interface DataSource {
    void writeData(String data);

    String readData();
}