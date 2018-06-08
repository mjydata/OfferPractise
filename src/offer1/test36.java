package offer1;

import java.lang.management.GarbageCollectorMXBean;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class test36 {
    public static int GetNumberOfK(int [] array , int k) {
        int length = array.length;
        if(length == 0){
            return 0;
        }
        int Findex=  findFirst(array,k,0,array.length-1);
        int Lindex=  findLast(array,k,0,array.length-1);
        if(Findex != -1 && Lindex != -1){
            int count =Lindex-Findex+1;
            return count;
        }
        return 0;



    }
    public static int findFirst(int[] array,int k,int low,int high){

        while(low<=high){
            int middle=(low+high)>>>1;
            if(k<array[middle]){
                high=middle-1;
            }else if (k>array[middle]){
                low=middle+1;
            }else if (middle>0&&array[middle-1]==k){
                 high=middle-1;

            }else {
                return middle;
            }

        }
        return -1;
    }
    public static int findLast(int[] array,int k,int low,int high){

        while(low<=high){
            int middle=(low+high)>>>1;
            if(k<array[middle]){
                high=middle-1;
            }else if (k>array[middle]){
                low=middle+1;
            }else if (middle<array.length-1&&array[middle+1]==k){
                low=middle+1;
            }else {
                return middle;
            }
        }
        return -1;
    }
    public static void main(String[] args){
      int[] arr={1,2,3,3,3,3};
        System.out.print(GetNumberOfK(arr,3));
    }
}
