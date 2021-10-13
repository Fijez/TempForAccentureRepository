package m02basics.tasks;

public class RandomGenerator {

    /**
     * @param length длина массива, не может быть больше 10
     * @return Массив, содержащий уникальные цифры. Например, для length = 4, это 1234, 4796, 3407 и т.д.
     * @throws IllegalArgumentException при некорректной входной длине (throw new IllegalArgumentException())
     */
    public static int[] generate(int length) throws IllegalArgumentException {
        if(!(length <=10 && length > 0)) {
            throw new IllegalArgumentException();
            }
        int[] arr = new int[length];
        int[] arrNumb = {0,1,2,3,4,5,6,7,8,9};
        int sizeArrNumb = 10;
        for (int i = 0; i < length; i++) {
            int forTemp = (int) (Math.random() * 10);
            int temp =  ( forTemp % sizeArrNumb);
            arr[i] = arrNumb[temp];
            sizeArrNumb--;
            arrNumb[temp] = arrNumb[sizeArrNumb];

        }
        return arr;
    }
}
