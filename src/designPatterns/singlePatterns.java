package designPatterns;

	import java.math.BigInteger;
	import java.util.Arrays;
	import java.util.Scanner;

public class singlePatterns {
   private static final singlePatterns singlePatterns=null;
   private singlePatterns() {
   }
   public static singlePatterns getInstance(){
	   if (singlePatterns==null) {
		       synchronized (singlePatterns.class) {
			    	   if (singlePatterns==null) {
			    	   return new singlePatterns();	
			       }
			  
		        }
	   }
	   return singlePatterns;
   }
	public static void main(String[] args){
			Scanner scanner=new Scanner(System.in);
			int n=scanner.nextInt();
			int[] arr=new int[n];
			for (int i=0;i<n;i++){
				arr[i]=scanner.nextInt();
			}
		    Arrays.sort(arr);
			for(int i=0;i<3;i++){
				for (int j=0;j<n-1;j++){
					if (arr[j]>arr[j+1]){
						int temp =arr[j];
						arr[j]=arr[j+1];
						arr[j+1]=temp ;
					}
				}
			}
			for(int i=0;i<2;i++){
				for (int j=n-1;j>0;j--){
					if (arr[j]<arr[j-1]){
						int temp =arr[j];
						arr[j]=arr[j+1];
						arr[j+1]=temp ;
					}
				}
			}

		BigInteger num1 = new BigInteger(String.valueOf(arr[n-1]));
		BigInteger num2 = new BigInteger(String.valueOf(arr[n-2]));
		BigInteger num3 = new BigInteger(String.valueOf(arr[n-3]));
		BigInteger res1 = num1.multiply(num2).multiply(num3);
		BigInteger num4 = new BigInteger(String.valueOf(arr[0]));
		BigInteger num5 = new BigInteger(String.valueOf(arr[1]));
		BigInteger res2 = num4.multiply(num5).multiply(num1);

			System.out.print(res1.compareTo(res2)<0?res2:res1.toString());
	}
	public  static  void ss(int offset,int n,int l1,int l2){

		int start1,end1,start2,end2;
		int begin=offset;
		int mid=begin+n;
		if(mid<=l1){
			start1=begin;
			end1=begin+n;
			start2=0;
			end2=0;
		}else if(begin<l1&&mid>l1&&(l1+l2)>=mid){
			start1=begin;
			end1=l1;
			start2=0;
			end2=l1-begin;
		}else if ((l2+l1)>begin&&begin>=l1&&mid>l1&&(l2+l1)>mid){
			start1=l1;
			end1=l1;
			start2=begin-l1;
			end2=begin-l1+n;
		}else if(begin>(l1+l2)){
			start1=l1;
			end1=l1;
			start2=l2;
			end2=l2;
		}
		else {
			start1=l1;
			end1=l1;
			start2=begin-l1;
			end2=l2;
		}
		System.out.print(start1+" "+end1+" "+start2+" "+end2);
	}
}
