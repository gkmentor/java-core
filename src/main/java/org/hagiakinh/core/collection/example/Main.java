package org.hagiakinh.core.collection.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();

        Object object = new Object();

        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("A");
        set.add("C");
        set.remove("A");
        System.out.println(set);

        LinkedList<String>[] linkedLists = new LinkedList[6];
        HashMap<String, String> hashMap = new HashMap<>();
    }
}
