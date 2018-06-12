package offer1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class test51 {
    public static int[] multiply(int[] A) {
       int[] B =new int[A.length];
       B[0]=1;
       //计算下三角
       for (int i=1;i<A.length;i++){
           B[i]=B[i-1]*A[i-1];
       }
       int temp=1;
       //计算上三角
       for (int j=A.length-2;j>=0;j--){
           temp*=A[j+1];
           B[j]*=temp;
       }
       return  B;
    }
    public static  void main(String[]  args){
        int[] a={1,2,3,4,5};
       System.out.println( multiply(a)[0]);
    }
}