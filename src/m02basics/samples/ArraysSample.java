package m02basics.samples;

public class ArraysSample {

	public static void main(String[] args) {
		int[] squares = new int[10]; // создание массива на 10 элементов
		int[] numbers = {1, 5, 3, 6, -4}; // создание и инициализация массива на 5 элементов

		// инициализация массива и вывод его элементов
		for(int i = 0; i < squares.length; i++) {
			squares[i] = i * i;
			System.out.println("Элемент:" + squares[i]);
		}

		// подсчет суммы элеметнов массива
		int sum = 0;
		for(int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		System.out.println("Сумма элементов массива: " + sum);

		// Создание и инициализация массива без объявления переменной
		System.out.println(new int[] {1, 2, 3});

		// создание двумерного массива 3x3
		int[][] intGrid = new int[3][3];
		// создание и инициализация матрицы 2x2
		String[][] stringGrid = {{"1x1", "1x2"}, {"2x1", "2x2"}};

		for(int i = 0; i < intGrid.length; i++) {
			for(int j = 0; j < intGrid[i].length; j++) {
				intGrid[i][j] = i + j;
				System.out.println(i + ":" + j + "=" + intGrid[i][j]);
			}
		}

		// создание двумерного массива 5 x переменной длины
		String[][] grid2 = new String[5][];
		for(int i = 0; i < grid2.length; i++) {
			grid2[i] = new String[i + 1];
			for(int j = 0; j < grid2[i].length; j++) {
				grid2[i][j] = "X";
			}
		}

		// Вывод массива переменной длины
		for(int i = 0; i < grid2.length; i++) {
			for(int j = 0; j < grid2[i].length; j++) {
				System.out.print(grid2[i][j]);
			}
			System.out.println();
		}
	}
}
