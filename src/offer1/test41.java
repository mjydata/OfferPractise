package offer1;

import jdk.nashorn.internal.ir.IdentNode;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class test41 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
           ArrayList<Integer> al=new ArrayList<>();
           int indexFirst=0;
           int indexLast=array.length-1;
           while(indexFirst<indexLast){
               if ((array[indexFirst]+array[indexLast])>sum){
                   indexLast--;
               }else if((array[indexFirst]+array[indexLast])<sum){
                    indexFirst++;
               }else{
                   al.add(array[indexFirst]);
                   al.add(array[indexLast]);
                   break;
               }

           }

           return al;
    }
}
