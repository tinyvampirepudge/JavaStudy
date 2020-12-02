package com.qding.javastudy;

import java.util.Arrays;
import java.util.List;

public class ForEachTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1", "2");
        for (String item : strings) {
            System.out.println(item);
        }
    }
}
