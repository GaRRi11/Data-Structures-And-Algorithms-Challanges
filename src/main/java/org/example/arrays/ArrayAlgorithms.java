package org.example.arrays;

public class ArrayAlgorithms {


    static int [] method(int [] array){
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1){
                k++;
            }
        }
        int [] array2 = new int[k];
        int p = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1){
                array2[p] = array[i];
                p++;
            }
        }
        return array2;
    }
//

    //1345
    //2678


    static int[] mergeeArrays(int [] arr1, int [] arr2){

        int [] newArray = new int[arr1.length+arr2.length];

        for (int i = 0; i < newArray.length; i++) {
            if (i <= arr1.length-1){
                newArray[i] = arr1[i];
            }
            if (i <= arr2.length-1){
                newArray[arr1.length+i] = arr2[i];
            }
        }

        int n = newArray.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (newArray[j] > newArray[j+1]){
                    int temp = newArray[j];
                    newArray[j] = newArray[j+1];
                    newArray[j+1] = temp;
                }
            }
        }

        return newArray;
    }


     static int [] findSum(int [] arr, int n ){
        int [] result = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i]+arr[j] == n){
                    result[0] = arr[i];
                    result[1] = arr[j];
                    return result;
                }
            }
        }
        return arr;
    }

    static int findMinimum(int [] arr){
        int result = arr[0];
            for (int j = 0; j < arr.length; j++) {
                if (result > arr[j]){
                    result = arr[j];
                }
            }

        return result;
    }

    static int findFirstUnique(int [] arr){
        int result = 0;
        boolean c = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i] == arr[j] && i != j){
                    c = false;
                    break;
                }else if (arr[i] != arr[j] && i != j){
                    c = true;
                }
            }
            if (c){
                result = arr[i];
                break;
            }
        }
        return result;
    }
    //9,2,3,2,6,6

    static int findSecondMaximum(int [] arr){
        int firstMaximum = arr[0];
        int secondMaximum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>firstMaximum){
                firstMaximum = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>secondMaximum && arr[i] != firstMaximum){
                secondMaximum = arr[i];
            }
        }
        return secondMaximum;
    }

    static int findSecondMax2(int [] arr){
        int max = arr[0];
        int secondMax = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                secondMax = max;
                max = arr[i];
            }else if (arr[i]>secondMax && arr[i] != max){
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    //9,2,3,2,6,6


   public static void rotateArray(int [] arr){
        int last = arr[arr.length-1];
        for (int i = arr.length-1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = last;
    }


    static void reArrange(int [] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<0){
                int temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;
                count++;
            }
        }

    }

    //1,2,3,4,5,6,7 // 0 1 0 2 0 3 4
    //7,1,6,2,5,3,4
    //7,6,5,4,3,2,1
    //step1

    static void maxMin(int [] arr){
        int [] result = new int[arr.length];
        int small = 0;
        int large = arr.length-1;
        boolean switcher = true;

        for (int i = 0; i < arr.length; i++) {
            if (switcher){
                result[i] = arr[large--];
            }else {
                result[i] = arr[small++];
            }

            switcher = !switcher;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }


}
