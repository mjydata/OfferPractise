package offer1;

import java.util.LinkedList;
/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author mjy
 *
 */

public class test13 {
 public int[] reOrderArray(int[] arr){
	for(int i=0;i<arr.length;i++){
		for(int j=0;j<arr.length-i;j++){
			if (arr[j]%2==0&&arr[j+1]%2==1) {
				 int temp=arr[j];
				 arr[j]=arr[j+1];
				 arr[j+1]=temp;
			}
		}
	}
	return arr;
 }
}
