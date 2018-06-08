package offer1;
/*
在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class test34 {
    public int FirstNotRepeatingChar(String str) {
        if(str.equals("")){
            return -1;
        }
        char[] arr=str.toCharArray();
        for (int i=0;i<arr.length;i++){
            while(onlyOne(arr,arr[i]))  {
                return i;

            }
        }

        return 0;
    }
    public boolean onlyOne(char[] arr ,char c){
        int count =0;
        boolean shift=true;
        for (int i=0;i<arr.length;i++){
            if (arr[i]==c){
                count++;
                if (count>=2 ){
                    shift=false;
                    break;
                }
            }
        }
        return  shift;

    }
}

