/*Домашка 9.1) Заполнить массив случайными числами. Подсчитать:
- количество элементов которые больше своего соседа слева
- количество четных элементов
- количество элементов которые меньше среднего арифметического*/

package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int arr[] = createRandomArray();
        int largestNeighbour = calculatelargestNeighbour(arr);
        System.out.println("Количество элементов которые больше своего соседа слева: " + largestNeighbour);
        int evenNumber = calculateEvenNumber(arr);
        System.out.println("Количество четных элементов: " + evenNumber);
        int top = calculateTop(arr);
        System.out.println("количество элементов которые меньше среднего арифметического: " + top);
    }

    private static int[] createRandomArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину массива");
        int length = scanner.nextInt();
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = -0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    private static int calculatelargestNeighbour(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                return count;
            }
            if (arr[i + 1] > arr[i]) {
                count++;
            }
        }
        return count;
    }

    private static int calculateEvenNumber(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private static double calculateAverage(int[] arr) {
        double average = 0.0;
        for (int i = 0; i < arr.length; i++) {
            average += arr[i];
        }
        average = average / arr.length;
        return average;
    }

    private static int calculateTop(int[] arr) {
        int top = 0;
        double average = calculateAverage(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < average) {
                top++;
            }
        }
        return top;
    }
}