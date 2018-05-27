package sort;

public class sort {
	public static void main(String[] args){
        int[] arr={6,1,10,23,43,5,4,55,656,7,545343,23,32,4354};
        quickSort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }
	/*
	 * 直接插入排序:	先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
	 * O(n^2)） 
	 */
	public static void insertSort(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			int j;
			for (j =i-1 ; j >=0; j--) {
			     if (arr[i]<arr[j]) {
			    	 arr[j+1]=arr[j];
			     }else {	
					break;
				}
			}
			arr[j+1]=arr[i];
		}
	}
	/**
	 * 简单选择排序 O（n^2）
	 * 在要排序的一组数中，选出最小（或者最大）的一个数与第1个位置的数交换；然后在剩下的数当中再找最小（
	 * 或者最大）的与第2个位置的数交换，
	 * 依次类推，直到第n-1个元素（倒数第二个数）和第n个元素（最后一个数）比较为止。
	 */
	public static void  simpleSelectSort(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {//找到最小值的下标
			int k=i;
			for (int j=i+1;j<arr.length;j++){
				if (arr[k]>arr[j]) {
					k=j;
				}
			}
			int temp =arr[k];
			arr[k]=arr[i];
			arr[i]=temp;
					
		}
	}
	/*
	 * 冒泡排序 O（n^2)
	 */
	public static void bubbleSort(int[] arr){
		for(int i=0;i<arr.length;i++){
			for (int j = 0; j < arr.length-i-1; j++) {
				if (arr[j]>arr[j+1]) {
					int temp =arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	/*
	 * 快速排序
	 */
	
	public static void quickSort(int[] arr,int low ,int high){
		if (low <high ){
			int middle = getMiddle(arr,low,high);
			quickSort(arr,0,middle-1);
			quickSort(arr,middle+1,high);
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
