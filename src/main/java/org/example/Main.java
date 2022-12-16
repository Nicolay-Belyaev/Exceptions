package org.example;

public class Main {
    public static void main(String[] args) {
        float[] arrB = new float[]{2, 4, 5, 12};
        float[] arrA = new float[]{2, 3, 4, 5};
        ArrayDiv arrayPair = new ArrayDiv(arrA, arrB);
        arrayPair.arrayDifference();
        arrayPair.arrayDivider();
        }
    }
