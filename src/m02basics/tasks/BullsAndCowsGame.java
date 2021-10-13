package m02basics.tasks;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * Реализовать консольный вариант игры «быки и коровы»
 * Вначале пользователю предлагается ввести сложность игры – 3, 4 или 5. Сложность игры – длина загадываемой программой последовательности цифр (0-9).
 * При вводе некоректной сложности игра завершается.
 * После определения сложности игры, программа генерирует случайную последовательность цифр, при чем все цифры должны быть разными(например, 0247).
 * После этого пользователю предлагает ввести свою отгадку последовательности. Валидной попыткой считается последовательность различных цифр правильной
 * длины (например, 1234). Невалидные попытки отклоняются.
 * Для валидной попытки программа должна выдать пользователю результат совпадения – 2 числа:
 * 1 число – «коровы» – число угаданных цифр, которые находятся на неправильных позициях;
 * 2 число – «быки» - число угаданных цифр, которые находятся на правильных позициях;
 * Если после попытки пользователь полностью правильно угадал загаданную последовательность, то ему выводится сообщение об успехе, значение загаданной
 * последовательности и количество попыток. Игра завершается.
 * Если после попытки пользователь не угадал последовательность, то ему предлагается сделать следующую попытку.
 * В качестве попытки пользователь может напечатать «сдаюсь». Тогда ему будет выведена загаданная последовательность и игра завершится.
 */
public class BullsAndCowsGame {


    private static final String GIVE_UP = "сдаюсь";
    private static final int[]NEXT_TRY = new int[0];
    private static final int[]LOSE = new int[1];
    private static final int[]WIN_GAME = new int[2];
    private static int ATTEMPTS = 0;

    public static void main(String[] args) {
        int dif = choseDif();
        int[] sequence = randSequence(dif);
        int sequenceLength = Objects.requireNonNull(sequence).length;
        int[] playerSequence;
        do {
            playerSequence = playerTurn(sequenceLength);
            ATTEMPTS++;
            int[] ints = checkResult(playerSequence, sequence);
            if (ints == NEXT_TRY) {
                continue;
            } else if (ints == LOSE) {
                System.out.println("Вы сдались, вот искомая последовательность: " + Arrays.toString(sequence));
                return;
            } else if (ints == WIN_GAME) {
                System.out.println("Вы победили!!!"
                        + System.lineSeparator()
                        + System.lineSeparator()
                        + "последовательность: " + Arrays.toString(sequence)
                        + "кол-во попыток: " + ATTEMPTS
                        + System.lineSeparator());
                return;
            }
        }
        while(true);
    }

    public static int choseDif() {
        System.out.println("Введжите сложность: 3 (длина последовательности 4)" +
                System.lineSeparator() +
                "4 (длина последовательности 6)" +
                System.lineSeparator() +
                "5 (длина последовательности 9)" +
                System.lineSeparator());
        int dif = new Scanner(System.in).nextInt();
        if (dif >= 3 && dif <= 5) {
            return dif;
        } else {
            return -1;
        }
    }

    public static int[] randSequence(int dif) {
        switch (dif) {
            case 3:
                System.out.println("");
                return RandomGenerator.generate(4);
            case 4:
                return RandomGenerator.generate(6);
            case 5:
                return RandomGenerator.generate(9);
        }
        return null;
    }

    public static int[] playerTurn(int arrSize) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ход игрока(введите число чтобы играть или \"сдаюсь\", чтобы закончить игру): ");
        String playerInput = scanner.nextLine();
        char[] tempChar = playerInput.toCharArray();
        if ( isNumeric(playerInput)) {
            if(playerInput.length() == arrSize) {
                int[] playerArr = new int[arrSize];
                for (int i = 0; i < arrSize; i++)
                    playerArr[i] = Character.getNumericValue(tempChar[i]);
                return playerArr;
            }
            else {
                System.out.println("неверная длина последовательности");
                return NEXT_TRY;
            }
        } else {
            if(playerInput.equals(GIVE_UP)) {
                System.out.println("вы сдались");
                return LOSE;
            }
            else {
                System.out.println("неверный ввод данных.");
                return NEXT_TRY;
            }
        }
    }

    public static int[] checkResult(int[] playerInput, int[] randNumb) {

        switch (playerInput.length) {
            case 0:
                return NEXT_TRY;
            case 1:
                return LOSE;
            default:
                int playerInputLength = playerInput.length;
                int cow = 0;
                int bull = 0;
                for (int i = 0; i < playerInputLength; i++) {
                    if (playerInput[i] == randNumb[i]) {
                        bull++;
                    } else {
                        for (int j = 0; j < playerInputLength; j++) {
                            if (playerInput[i] == randNumb[j]) {
                                cow++;
                                break;
                            }
                        }
                    }
                }
                if (bull == playerInputLength) {
                    return WIN_GAME;
                } else {
                    System.out.println("cows: " + cow
                            + System.lineSeparator()
                            + "bulls " + bull);
                    return NEXT_TRY;
                }
        }
    }

    public static boolean isNumeric(String string) {
        int intValue;
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }}