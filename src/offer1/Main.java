package offer1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
             String[] str= in.nextLine().split(" ");
             String array= in.nextLine();
             int n=Integer.parseInt(str[0]);
             int m=Integer.parseInt(str[1]);
             String arr[]=array.split(" ");
             int[] lists=new int[n];
             for(int i=0;i<n;i++)
             lists[i] =Integer.parseInt(arr[i]);
             if(m==1){
            	 System.out.println(sum(lists,0,n));
             }
        }
    }
    public static  void splitLis(int[] lists,int n,int m){
    	List listresult=new ArrayList<>();
    	if(n==m){
//    		listresult.add();
    	}
//    	return splitLis(lists,n-1, m-1);
    }
    public static int sum(int[] lists,int start,int end){
    	int sum=0;
    	for(int i=start;i<end;i++){
    		sum+=lists[i];
    	}
    	return sum;
    }
}