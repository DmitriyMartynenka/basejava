package com.basejava.webapp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainStream {
    private static int[] values = {4, 2, 2, 5, 4, 7};
    private static List<Integer> list = Arrays.stream(values).boxed().collect(Collectors.toList());

    public static void main(String[] args) {
        minValue(values);
//        System.out.println(oddOrEven(list));
    }

    private static int minValue(int[] values) {
        int[] array = Arrays.stream(values).distinct().sorted().toArray();
        int sum = IntStream.range(0, array.length).map((i) -> (int) Math.pow(10, array.length - 1 - i) * array[i]).sum();
        System.out.println(sum);
        return sum;
    }

    private static List<Integer> oddOrEven(List<Integer> integers) {
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        if (sum % 2 == 0) {
            return list.stream().filter(x -> x % 2 == 1).collect(Collectors.toList());
        } else {
            return list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        }
    }
}