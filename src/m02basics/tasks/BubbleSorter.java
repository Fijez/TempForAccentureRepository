package m02basics.tasks;

public class BubbleSorter {

    /**
     * Реализовать сортировку элементов массива по возрастанию алгоритмом пузырька
     * @param array входной массив целых чисел
     */
    public static void sort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int temp = array[0];
            boolean flag = false;
            for (int j = 1; j < length; j++) {
                if (temp > array[j]) {
                    array[j-1] = array[j];
                    flag = true;
                }
                else if (temp < array[j]){
                    array[j-1] = temp;
                    temp = array[j];
                }
            }
            array[length-1] = temp;
            if (flag == false) {
                break;
            }
            length--;
        }
    }
}
