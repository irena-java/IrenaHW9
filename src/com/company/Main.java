/*4*) Подсчитать количество треугольников, у которых стороны заданы целыми числами,
и площадь которых не больше 100

 4.1*) Сделать задание так чтобы не было повторяющихся треугольников, например (3,4,5) и (5,3,4) - повторяющиеся. */

package com.company;

public class Main {
    public static void main(String[] args) {
        double square;
        int count = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 1; j < 1000; j++) {
                for (int k = 1; k < 1000; k++) {
                    square = formulaGerona(i, j, k);
                    if (square <= 100 & square > 0) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count + " треугольников,");
        System.out.println("из них неповтояющихся: " + count / 3);
        System.out.println("или как предполагалось сделать?");
    }

    private static double formulaGerona(int i, int j, int k) {
        double halfPerimetr = (i + j + k) / 2.0;
        try {
            double square = Math.sqrt(halfPerimetr * (halfPerimetr - i) * (halfPerimetr - j) * (halfPerimetr - k));
            return square;
        } catch (Exception e) {
            return 999;
        }
    }
}