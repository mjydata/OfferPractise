package leetcode;


import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        int a[][]=new int[4][100];
        int n=4;
        Scanner in=new Scanner(System.in);
        for(int i=0;i<n;i++){
            String strLine = in.nextLine();
            Scanner s = new Scanner(strLine);
            int j=0;
            while(s.hasNextInt()){
                a[i][j++]=s.nextInt();
            }
        }
        int m=a[2][0];

        for(int i=0;i<m;i++)
        {
            int j=0;
            int sum=a[1][j];
            if(a[3][i]<=sum)
                System.out.println(j+1);
            else
            {
                while(a[3][i]>sum)
                {
                    j++;
                    sum=sum+a[1][j];
                }
                System.out.println(j+1);

            }
        }
    }



}