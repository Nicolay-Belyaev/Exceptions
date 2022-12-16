package org.example;

public class ArrayDiv {
    private final float[] arrA;
    private final float[] arrB;
    private final float[] arrC;
    private final int lengthA;

    public ArrayDiv(float[] arrA, float[] arrB) {
        if (arrA == null || arrB == null) {throw new RuntimeException("Какой-то (или оба) массив - Null.");}
        this.arrA = arrA;
        this.arrB = arrB;
        lengthA = arrA.length;
        int lengthB = arrB.length;
        if (lengthA == 0 || lengthB == 0) {throw new RuntimeException("Какой-то (или оба) массив пустой");}
        if (lengthA != lengthB) {throw new RuntimeException("Массивы разной длинны.");}
        arrC = new float[lengthA];
    }

    public void arrayDifference() {
        for (int i = 0; i < lengthA; i++) {
            arrC[i] = arrA[i] - arrB[i];
        }
        resultPrinter();
    }

    public void arrayDivider(){
        for (int i = 0; i < lengthA; i++) {
            if (arrB[i] == 0) {
                throw new RuntimeException("Попытка деления на ноль.");
            }
            arrC[i] = arrA[i] / arrB[i];
        }
        resultPrinter();
    }

    private void resultPrinter() {
        System.out.print("[");
        for (int i = 0; i < arrC.length - 1; i++) {
            System.out.print(arrC[i] + " ");
        }
        System.out.println(arrC[arrC.length-1] + "]");
    }
}
