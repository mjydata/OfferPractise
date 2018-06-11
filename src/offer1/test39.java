package offer1;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class test39 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        num1[0]=0;
        num2[0]=0;
        int result=array[0];
        for(int i=1;i<array.length;i++){
             result =result^array[i];//异或：相同为0，不同为1
         }
         int index=findFirstBit1(result);
        for (int i:array){
            if (isBit1(i,index)){
                num1[0]^=i;
            }else{
                num2[0]^=i;
            }

        }

    }
    private  int findFirstBit1(int num){
        int index =0;
         while((num&1)==0&&index<32){//两个操作数中位都为1，结果才为1，否则结果为0;或 ：两个位只要有一个为1，那么结果就是1，否则就为0，
             index++;
             num>>>=1;
         }
         return index;
    }
    private  boolean isBit1(int num,int index){
        num >>>=index;
        if ((num&1)==1){
          return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] data1 = {2,4,3,6,3,2,5,5};
        int[] data2=new int[1];
        int[] data3=new int[1];
        new test39().FindNumsAppearOnce(data1,data2,data3);
System.out.print(data2[0]);
        System.out.print(data3[0]);
    }
}
