package org.hagiakinh.design_pattern.structural.decorator;

import org.hagiakinh.design_pattern.structural.decorator.decorators.CompressionDecorator;
import org.hagiakinh.design_pattern.structural.decorator.decorators.DataSource;
import org.hagiakinh.design_pattern.structural.decorator.decorators.DataSourceDecorator;
import org.hagiakinh.design_pattern.structural.decorator.decorators.EncryptionDecorator;
import org.hagiakinh.design_pattern.structural.decorator.decorators.FileDataSource;

public class Demo {
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("src/main/resources/design-pattern/out/OutputDemo.txt")));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("src/main/resources/design-pattern/out/OutputDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }
}
