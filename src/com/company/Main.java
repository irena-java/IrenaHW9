/*Домашка 9.*3*)Написать метод который ищет при помощи бинарного поиска
        есть ли число в отсортированном массиве*/

package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = createRandomArray();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число, которое надо найти в массиве:");
        int number = scanner.nextInt();
        if (isInTheArray(arr, number, 0, arr.length - 1)) {
            System.out.println("Число находится в массиве");
        } else {
            System.out.println("Числа нет в массиве");
        }
    }

    private static boolean isInTheArray(int[] arr, int number, int indexBegin, int indexEnd) {
        int middle = indexBegin + (indexEnd - indexBegin) / 2;
        if (number == arr[middle]) {
            return true;
        } else if (middle == 0) {
            if (arr.length > 1) {
                if (arr[1] == number) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } else if (middle == arr.length - 2) {
            if (number == arr[arr.length - 1] || number == arr[0]) {
                return true;
            } else {
                return false;
            }
        } else {
            if (number > arr[middle]) {
                indexBegin = middle;
            } else {
                indexEnd = middle;
            }
            return isInTheArray(arr, number, indexBegin, indexEnd);
        }
    }

    private static int[] createRandomArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину массива");
        int length = scanner.nextInt();
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = -0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
}