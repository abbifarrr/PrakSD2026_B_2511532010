package pekan8_2511532010;
import java.util.*;
public class QuickSort_2511532010 {
static void swap (int[] arr, int i_2010, int j_2010)
{
	int temp_2010 = arr[i_2010];
			arr[i_2010] = arr[j_2010];
			arr[j_2010]=temp_2010;
}

static void medianOfThree (int[] arr, int low_2010, int high_2010)
{
	int mid_2010 = low_2010 + (high_2010-low_2010)/2;
	if (arr[low_2010] > arr[mid_2010]) {
		swap(arr, low_2010, mid_2010);
	}
	if (arr[low_2010] > arr[high_2010]) {
		swap(arr, low_2010, high_2010);
	}
	if (arr[mid_2010] > arr[high_2010]) {
		swap(arr, mid_2010, high_2010);
	}
	swap (arr, mid_2010, high_2010);
}

static int partition (int[] arr, int low_2010, int high_2010)
{
	medianOfThree(arr, low_2010, high_2010);
	int pivot_2010 = arr[high_2010];
	int i_2010 = (low_2010 - 1);
	
	for (int j_2010 = low_2010; j_2010<= high_2010-1; j_2010++) {
		if (arr[j_2010] < pivot_2010) {
			i_2010++;
			swap(arr, i_2010, j_2010);
		}
	}
	swap (arr, i_2010+1, high_2010);
	return (i_2010 + 1);
}

static void QuickSort (int[]arr, int low_2010, int high_2010) {
	if (low_2010< high_2010) {
		int pi_2010 = partition (arr, low_2010, high_2010);
		QuickSort(arr, low_2010, pi_2010-1);
		QuickSort(arr, pi_2010 + 1, high_2010);
	}
}

public static void printArr(int[] arr)
{
	for (int i_2010 = 0; i_2010<arr.length; i_2010++) {
		System.out.print(arr[i_2010]+ " ");
	}
	System.out.println();
	}

public static void main(String[]args)
{
	int[] arr = {10,7,8,9,1,5};
	int N_2010 = arr.length;
	System.out.print("Data sebelum diurutkan : ");
	printArr(arr);
	
	QuickSort (arr, 0, N_2010 - 1);
	
	System.out.print("Data Terurut Quicksort : ");
	printArr(arr);
}
}
