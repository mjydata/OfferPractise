package offer1;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 输入描述:
 输入一个字符串,包括数字字母符号,可以为空
 */
public class test49 {
    public static int StrToInt(String str) {

        if (str.equals("")||str.length()==0){
            return  0;
        }
        int shift=0;
        if (str.toCharArray()[0]=='-'){
            shift=1;
        }
        int sum=0;
        int a=1;
        for (int i=str.length()-1;i>=shift;i--){
            if (str.toCharArray()[i]=='+'){
                continue;
            }
            if (str.toCharArray()[i]<'0' || str.toCharArray()[i]>'9'){
                return  0;

            }
            sum+=(str.toCharArray()[i]-'0')*a;
            a*=10;
        }

        return shift==1?sum*(-1):sum;
    }
    public static  void main(String[] ars){
        System.out.print(StrToInt("-92"));
    }
}
