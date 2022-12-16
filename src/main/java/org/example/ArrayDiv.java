package org.example;

public class ArrayDiv {
    private final float[] arrA;
    private final float[] arrB;
    private final float[] arrC;
    private final int arrALength;
    private final int arrBLength;

    public ArrayDiv(float[] arrA, float[] arrB) {
        if (arrA == null || arrB == null) {
            throw new RuntimeException("Один, либо оба входящих массива = Null.");
        }
        this.arrA = arrA;
        this.arrB = arrB;
        arrALength = arrA.length;
        arrBLength = arrB.length;
        if (arrALength == 0 || arrBLength == 0) {
            throw new RuntimeException("Один, либо оба входящих массива не содержит(ат) элементов.");
        }
        arrC = new float[arrALength];
    }

    public void arrayDifferenceVar1() {
        if (arrALength != arrBLength) {
            throw new RuntimeException("Массивы разной длинны.");
        }
        for (int i = 0; i < arrALength; i++) {
            arrC[i] = arrA[i] - arrB[i];
        }
        resultPrinter();
    }
    
    // самый кривой способ.
    public void arrayDifferenceVar2() {
        if (arrALength != arrBLength) {
            ErrorHandler();
        } else {
            for (int i = 0; i < arrALength; i++) {
                arrC[i] = arrA[i] - arrB[i];
            }
            resultPrinter();
        }
    }
    private void ErrorHandler(){
        System.out.println("Массивы разной длинны.");
    }

    public void arrayDivider(){
        if (arrALength != arrBLength) {
            throw new RuntimeException("Массивы разной длинны.");
        }
        for (int i = 0; i < arrALength; i++) {
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
