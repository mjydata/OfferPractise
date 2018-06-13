package offer1;

public class test4 {
    public static TreeNode reConstructBinaryTree(int[] pre,int[] in){
    	TreeNode root=reConstructBinaryTree(pre,0,pre.length,in,0,in.length);
    	return null;
    }
	public static TreeNode reConstructBinaryTree(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn){
		TreeNode root = null;
		if(startPre>endPre||startIn>endIn){
			return null;
		}
		root=new TreeNode(in[startPre]);
		for(int i=startIn;i<endIn;i++){
	    		if(in[i]==pre[startPre]){
	              		//??	
	              		root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-1,in,startIn,i-1);
	              		root.right=reConstructBinaryTree(pre,startPre+i+1,endPre,in,i+1,endIn);
	    		}
	    	}
	    	return root;
	    }
	    
}