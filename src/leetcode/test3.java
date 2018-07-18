package leetcode;

import java.util.HashMap;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 对于第一种思路如下：
 此方法是先将数组从小到大排序
 设置两个指针，一个指向数组开头，一个指向数组结尾，从两边往中间走。直到扫到满足题意的为止或者两个指针相遇为止。
 此时这种搜索方法就是类似于杨氏矩阵的搜索方法，就是从 杨氏矩阵的左下角开始搜索，直到找到为止。
 如果此时题目条件变为如果没有找出最接近的2SUM和问题，解决方法跟上面是一样的
 用这种方法2SUM问题的时间复杂度是O(nlogn)的，主要在于排序的时间。

 第二种思路方法如下：
 对数组中的每个数建立一个map/hash_map 然后再扫一遍这个数组，判断target-nums[i]是否存在，如果存在则说明有，不存在继续找。当然这样做的话，需要处理一个细节：判重的问题。
 代码如下【注意因为题目中说一定有解所以才下面这样写，如果不一定有解，则还要再加一些判断】
 */
public class test3 {
    public int[] twoSum(int[] numbers, int target) {
     HashMap<Integer,Integer> map=new HashMap<>();
     int[] res=new int[2];
     for (int i=0;i<numbers.length;i++){
         if (map.get(target-numbers[i])!=null){
             res[0]=map.get(target-numbers[i])+1;
             res[1]=i+1;
         }else {
              map.put(numbers[i],i);
         }

     }
     return res;
    }
    public static void main(String[] args) {
        int[] numbers = { 2, 7, 11, 15 };
        int target = 17;
        int[] result = new test3().twoSum(numbers, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
 class Point {
     int x;
     int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
 }
