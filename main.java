import java.util.ArrayList;

class Main{
     public static void main(String[] args) {
        int[] originalList = getNumberFromFile();
        // System.out.println(Arrays.toString(originalList));
        //Splits array to even and odd arraylist
        ArrayList<Integer> even = splitArray(originalList,true);
        ArrayList<Integer> odd = splitArray(originalList,false);
        System.out.println("Even: "+even.toString());
        System.out.println("Odd: "+ odd.toString());
        System.out.println("---");
        //-------------------------------------------------------------
        // Determing the highest and lowest for each even odd array
        int[] copyEven = arrayListToArray(even);
        int[] copyOdd = arrayListToArray(odd);
        bubbleSort(copyEven, copyEven.length); //sorting even array
        bubbleSort(copyOdd, copyOdd.length); //sorting odd array
        // System.out.println(Arrays.toString(copyEven));
        int lowest = copyEven[0];
        int highest = copyEven[copyEven.length-1];
        System.out.println("Even lowest: "+lowest);
        System.out.println("Even Highest: "+highest);
        int oddLowest = copyOdd[0];
        int oddHighest = copyOdd[copyOdd.length-1];
        System.out.println("Odd lowest: "+oddLowest);
        System.out.println("Odd  Highest: "+oddHighest);
        System.out.println("-----");

        //-------------------------------------------------------------
        //Find average
        double evenAverage = findAverage(copyEven);
        double oddAverage = findAverage(copyOdd);
        System.out.println("Even average: "+evenAverage);
        System.out.println("Odd average: "+ oddAverage);

    }



    private static double findAverage(int[] arr) {
        double average=0;
        for(int x =0; x< arr.length;x++){
            average+=arr[x];
        }
        average = average/arr.length;
        return average;
    }



    private static int[] arrayListToArray(ArrayList<Integer> list) {
        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++) arr[i] = list.get(i);
        return arr;
    }

    private static void bubbleSort(int[] arr ,int n) {
        // This is copied of the internet to sort array
        if (n == 1)                     //passes are done
        {
            return;
        }
        for (int i=0; i<n-1; i++)       //iteration through unsorted elements
        {
            if (arr[i] > arr[i+1])      //check if the elements are in order
            {                           //if not, swap them
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        bubbleSort(arr, n-1); 
    }

    private static ArrayList<Integer> splitArray(int[] originalList, boolean checkEven) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int x =0 ; x< originalList.length;x++){
            if(originalList[x]%2 == 0 && checkEven==true){
                list.add(originalList[x]);
            }
            else if(originalList[x]%2!=0 && checkEven==false){
                list.add((originalList[x]));
            }
        }
        return list;
    }

    private static int[] getNumberFromFile() {
        int[] num = {46, 30, 82, 90, 56, 95, 16, 48, 26,
            4, 58, 0, 78, 92, 60, 12, 21, 63,47,
            19, 41, 90, 85, 14, -9, 52, 71, 79, 16,
            80, 51, 95, 102, 34, 10, 79, 95, 61, 92,
            89, 88, 66, 64, 92, 63, 66, 64, 39, 5
        };
        return num;
    }



    

}
