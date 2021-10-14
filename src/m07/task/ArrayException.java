package m07.task;

/**
 * Представьте массив с заявленнымии 5 элементами, попробуйте вызвать 6 элемент
 *  при попытке вывести несущ-ий элемент программа выдают "Невозможно братиться к этому элементу, такого не существует"
 */

public class ArrayException {

    private static final int ARRAY_SIZE = 5;
    public static void main(String[] args) {
        double[] arrays = new double[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            arrays[i] = Math.random()*100;
        }
        try {
            double temp = arrays[5];
        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Невозможно братиться к этому элементу, такого не существует");
        }
    }
}