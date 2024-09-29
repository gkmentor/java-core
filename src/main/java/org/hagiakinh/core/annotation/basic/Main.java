package org.hagiakinh.core.annotation.basic;

@interface Entity {
}

@Entity
class User {
    private Long id;
    private String username;
    private String email;
}

public class Main {
    public static void main(String[] args) {

    }
}
