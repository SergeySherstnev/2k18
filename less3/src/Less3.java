package less3;

import java.util.Arrays;
import java.util.Scanner;

public class Less3 {
	public static void main (String[] args) {
		String[] arrStr, arrBubbleSorted, arrMergeSorted;
		String inScSt;
		int inScInt=0, cycles;
		long startSort, timeSort;
		
		System.out.print("Введите количество строк в массиве: ");
		Scanner sc = new Scanner(System.in);
		do {
			inScSt = sc.next();
			if (inScSt.matches("[-+]?\\d+"))
				inScInt = Integer.parseInt(inScSt);
		}while (inScInt < 1);
		sc.close();
		
		arrStr= new String[inScInt];
		arrBubbleSorted = new String[inScInt];
		arrMergeSorted = new String[inScInt];
		for (int i=0; i<inScInt; i++) {
			String symbols = "qwertyuiopasdfghjklzxcvbnm1234567890";
	        StringBuilder randString = new StringBuilder();
	        int count =0;
	        do {
	        	count = (int)(Math.random()*100);
	        } while (count<1);
	        for(int j=0;j<count;j++)
	          randString.append(symbols.charAt((int)(Math.random()*symbols.length())));
			arrStr[i]= new String(randString);
		}	
		System.out.println("\nМассив до сортировки:");
		for (int i=0; i<inScInt; i++) {
			System.out.println(arrStr[i]);
		}
		
		// Сортировка пузырьковым методом
		startSort = System.nanoTime();
		arrBubbleSorted = BubbleSort(arrStr);
		timeSort = System.nanoTime() - startSort;
		System.out.println("\nСортировка пузырьковым методом:");
		for (int i=0; i<inScInt; i++) {
			System.out.println(arrBubbleSorted[i]);
		}
		System.out.println("Быстродействие: " + timeSort/1000 + " мкс");
		
		// Сортировка методом слияния
		startSort = System.nanoTime();
		arrMergeSorted = MergeSort(arrStr);
		timeSort = System.nanoTime() - startSort;
		System.out.println("\nСортировка методом слияния:");
		for (int i=0; i<inScInt; i++) {
			System.out.println(arrMergeSorted[i]);
		}
		System.out.println("Быстродействие: " + timeSort/1000 + " мкс");
	}
	
	// Сортирока пузырьковым методом
	public static String[] BubbleSort (String[] arrToSort)	{
		boolean isSwapped;
		String tmpStr;
		String[] result = new String[arrToSort.length];
		result = Arrays.copyOf(arrToSort, arrToSort.length);
		
		do {
			isSwapped=false;
			for (int i=1; i<arrToSort.length; i++) {
				if (result[i-1].length() > result[i].length()) {
					tmpStr = result[i];
					result[i] = result[i-1];
					result[i-1] = tmpStr;
					isSwapped = true;
				}
					
			}
		} while (isSwapped);
		return result;
	}
	
	// Сортирока методом слияния
	public static String[] MergeSort (String[] arrToSort) {
		String[] buffer1 = Arrays.copyOf(arrToSort, arrToSort.length);
        String[] buffer2 = new String[arrToSort.length];
        String[] result = MergeSortInner(buffer1, buffer2, 0, arrToSort.length);
        
        return result;
			
	}
	
	// Сортирока методом слияния
	public static String[] MergeSortInner(String[] buffer1, String[] buffer2,
            int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }
        
        int middle = startIndex + (endIndex - startIndex) / 2;
        String[] sorted1 = MergeSortInner(buffer1, buffer2, startIndex, middle);
        String[] sorted2 = MergeSortInner(buffer1, buffer2, middle, endIndex);
        
        // Слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        String[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1].length() < sorted2[index2].length()
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
}
