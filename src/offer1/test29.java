package offer1;


import java.util.ArrayList;
/*
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class test29 {
    public static void main(String[] args){
        int[] arr={4,5,1,6,2,7,2,8};
        System.out.print(GetLeastNumbers_Solution(arr,2));


    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
       ArrayList lists=new ArrayList();
        quickSort(input,0,input.length-1,k);
        for (int i=0;i<k;i++){
            lists.add(input[i]);
        }
        return lists;

    }
    public static void quickSort(int[] arr,int low ,int high, int k){
        if (low <high ){
            int middle = getMiddle(arr,low,high);
            if(middle-1>k-1){
                quickSort(arr,0,middle-1,  k);
                quickSort(arr,middle+1,high,  k);
            }

        }

    }
    public static int getMiddle(int[] arr , int low ,int high){
        int key=arr[low];//基准元素，排序中会空出来一个位置
        while (low<high){

            while (low<high && arr[high]>=key ) {
                --high;
            }

            arr[low]=arr[high];
            while (low<high && arr[low]<=key ) {
                ++low;
            }
            arr[high]=arr[low];
        }
        arr[low]=key;

        return low;


    }
}
