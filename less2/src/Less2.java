import java.io.*;
import java.util.*;

public class Less2 {

    public static void main (String[] arg)
    {
        int i=0;
        char[] arrayOne = new char[5];
        String ch;
        int lnt;
        Scanner sc = new Scanner(System.in).useDelimiter("\\s*");

        System.out.println("Задача №1 ");
        System.out.println("Введите символы для массива (макс=5): ");
        ch = sc.nextLine();
        lnt = ch.length() > 5 ? 5 : ch.length();
        while (i<lnt ){
             arrayOne[i] = ch.charAt(i++);
        }
        for (int j=0; j<i ; j++) {
            System.out.print("[" + arrayOne[j] + "] ");
        }


        int[] arrayTwo;
        int arrLen=0;
        sc = new Scanner(System.in);
        System.out.println("\nЗадача №2 ");
        do {
            System.out.println("Введите количество элементов массива целых чисел: ");
            ch = sc.nextLine();
            if (ch.matches("[-+]?\\d+"))
                arrLen = Integer.parseInt(ch);
        } while(arrLen<1);
        arrayTwo = new int[arrLen];
        for (int j=0; j<arrLen; ) {
            System.out.print("Элемент №" + j + ": ");
            ch = sc.nextLine();
            if (ch.matches("[-+]?\\d+"))
                arrayTwo[j++] = Integer.parseInt(ch);
        }
        System.out.print("Массив: ");
        for (int j=0; j<arrayTwo.length ; j++) {
            System.out.print("[" + arrayTwo[j] + "] ");
        }


        System.out.println("\nЗадача №3 ");
        int max = arrayTwo[0];
        for(int j = 0; j < arrayTwo.length; j++) {
            if (arrayTwo[j] > max)
                max = arrayTwo[j];
        }
        System.out.println("Максимальное число: " + max);


        System.out.println("\nЗадача №4 ");
        int min = arrayTwo[0];
        for(int j = 0; j < arrayTwo.length; j++) {
            if (arrayTwo[j] < min)
                min = arrayTwo[j];
        }
        System.out.println("Минимальное число: " + min);


        int[][] arrayThree;
        int arrCol=0, arrRow=0;
        System.out.println("\nЗадача №5 ");
        do {
            System.out.println("Введите количество строк массива целых чисел: ");
            ch = sc.nextLine();
            if (ch.matches("[-+]?\\d+"))
                arrCol = Integer.parseInt(ch);
        } while (arrCol<1);
        do {
            System.out.println("Введите количество столбцов массива целых чисел: ");
            ch = sc.nextLine();
            if (ch.matches("[-+]?\\d+"))
                arrRow = Integer.parseInt(ch);
        } while (arrRow<1);
        arrayThree = new int[arrCol][arrRow];
        for (int j=0; j<arrCol; j++)
            for (int k=0; k<arrRow; ){
                System.out.print("Элемент [" + j + "] [" + k + "] :");
                ch = sc.nextLine();
                if (ch.matches("[-+]?\\d+"))
                    arrayThree[j][k++] = Integer.parseInt(ch);
            }
        int yui = arrayThree.length;
        System.out.println("Массив: ");
        for (int j=0; j<arrayThree.length ; j++) {
            for (int k = 0; k < arrayThree[j].length; k++) {
                System.out.print("[" + arrayThree[j][k] + "] ");
            }
            System.out.println("");
        }
    }
}
