package offer1;
/**
 * 
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author mjy
 * f(0) + f(1) + f(2) + f(3) + ... + f(n-1) == f(n) = 2*f(n-1)
 */
public class test9 {
    public int JumpFloorII(int n){
    	if (n<0){
    		return 0;
    	}if (n==1) {
			return 1;
		}else {
			return JumpFloorII(n-1)*2;	
		}
    	
    }
}
