package homework01;

public class Main {
    public static void main(String[] args) {
        float[] arrB = new float[]{2, 4, 5, 12};
        float[] arrA = new float[]{2, 3, 4, 5};
        ArrayHandler arrayPair = new ArrayHandler(arrA, arrB);
        arrayPair.arrayDifference();
        arrayPair.arrayDivider();
        }
    }
