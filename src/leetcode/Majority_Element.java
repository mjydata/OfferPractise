package leetcode;


import java.util.HashMap;
import java.util.Map;

/**169
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.

 Example 1:

 Input: [3,2,3]
 Output: 3
 Example 2:

 Input: [2,2,1,1,1,2,2]
 Output: 2
 */
public class Majority_Element {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap();
        for(int num:nums){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }
        int max=0;
        int key=nums[0];
        for(Map.Entry  entry :map.entrySet()){
            if ((int)entry.getValue()>max){
                max=(int)entry.getValue();
                key=(int)entry.getKey();
            }
        }
        return  key;
    }
}
