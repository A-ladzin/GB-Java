package Sem03.hw.MergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class program {
    public static void main(String[] args) {
        
        Integer[] arr = {1,5,4,6,1,2};
        // int[] sorted = mergeSort(arr);
        System.out.println(Arrays.stream(Arrays.asList(sorted).stream().mapToInt(i->i).toArray()).average().getAsDouble());

        // System.out.println(Arrays.toString(sorted));
        // System.out.println(removeEvenNumbers(arr));
    }



    public static int[] mergeSort(int[] arr)
    {
        int pivot = arr[0];
        int[] left = new int[0];
        int[] right = new int[0];
        for ( int i = 1; i<arr.length;i++){
            if (arr[i] < pivot)
            {
                int [] temp = new int[left.length+1];
                for(int j = 0; j < left.length; j++)
                {
                    temp[j] = left[j];
                }
                temp[left.length] = arr[i];
                left = temp;
            }
            else{
                int [] temp = new int[right.length+1];
                for(int j = 0; j < right.length; j++)
                {
                    temp[j] = right[j];
                }
                temp[right.length] = arr[i];
                right = temp;
            }
    }

    if (left.length > 0){
            left = mergeSort(left);
                }
    if (right.length > 0){
                    right = mergeSort(right);
                }
    int[] result = new int[arr.length];
    int idx = 0;
    for(int i: left) result[idx++] = i;
    result[idx++] = pivot;
    for(int i: right) result[idx++] = i;
    return result;
    }


    public static ArrayList<Integer> removeEvenNumbers(Integer[] arr) {
        // Введите свое решение ниже
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
        list.removeIf(i -> i%2 == 0);
        return list;
         
      }
}
