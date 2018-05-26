package offer1;

import javax.print.attribute.ResolutionSyntax;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 * @author mjy
 *
 */
public class test7 {
	public int Fibonacci(int n) {
        if(n<0){
            return -1;
        }else if(n==0){
            return 0;
        }else if(n==1||n==2){
            return 1;
        }else {
           
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }
	/**
	 * 非递归
	 * @return
	 */
	public int Fibonacci2( int n){
		int[] array=new int[n+2];
		array[0]=0;
		array[0]=1;
		for (int i = 2; i < array.length; i++) {
			array[i]=array[i-1]+array[i-2];
		}
		return array[n];
	}
	
}
