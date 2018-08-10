package offer1;
/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @author mjy
 *
 */

public class test23Important {
	    public boolean VerifySquenceOfBST(int[] sequ){
    		if(sequ.length==0) 
    			return false;
    		return isRight(sequ, 0, sequ.length-1);
    	}
    	public boolean isRight(int[] seq,int start,int end){
    		if(start>=end )        return true;
    		int i=end-1;
    		while(seq[i]>seq[end]&&i>start){
    			i--;
    		}
    		for (int j = start; j < i; j++) {
				if (seq[j]>seq[end-1]) {
					return false;
				}
			}
    		return isRight(seq, start, i)&&isRight(seq, i+1, end-1);
    	}
}
