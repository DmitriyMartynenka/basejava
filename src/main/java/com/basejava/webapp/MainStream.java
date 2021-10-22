package com.basejava.webapp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainStream {
    private static int[] values = {4, 3, 2, 5, 4, 7};
    private static List<Integer> list = Arrays.stream(values).boxed().collect(Collectors.toList());

    public static void main(String[] args) {
        System.out.println(minValue(values));
        System.out.println(oddOrEven(list));
    }

    private static int minValue(int[] values) {
        return Arrays.stream(values).distinct().sorted().reduce(0, (x, y) -> x * 10 + y);
    }

    private static List<Integer> oddOrEven(List<Integer> integers) {
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        return list.stream().filter(x -> x % 2 != sum % 2).collect(Collectors.toList());
    }
}