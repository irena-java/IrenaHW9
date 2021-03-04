/*Домашка 9.3 вариант 1 не получился, вопрос по отлавливанию get-catch бесконечной
рекурсии - почему не отлавливает, дальше сделала отдельным коммитом переделанный вариант,
 без использования get-catch
Написать метод который ищет при помощи бинарного поиска есть ли число в
отсортированном массиве*/

package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число, которое надо найти в массиве:");
        int number = scanner.nextInt();
        int[] arr = createRandomArray();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        try {
            System.out.println(isInTheArray(arr, number, 0, arr.length - 1));
        } catch (Exception e) {
            System.out.println("Этого числа нет в массиве");
        }
    }

    private static boolean isInTheArray(int[] arr, int number, int indexBegin, int indexEnd) {
        //try {
        int middle = indexBegin + (indexEnd - indexBegin) / 2;
        if (number == arr[middle]) {
            return true;
        } else {
            if (number > arr[middle]) {
                indexBegin = middle;
            } else {
                indexEnd = middle;
            }
            return isInTheArray(arr, number, indexBegin, indexEnd);
        }
        //} catch (Exception e) {
        //  System.out.println("gdfdgdfg");
//            return false;
        //      }
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

        arr[0] = 50;
        arr[1] = 60;
        arr[2] = 75;
        arr[3] = 80;
        arr[4] = 90;
        arr[5] = 100;
        arr[6] = 150;

        return arr;
    }
}