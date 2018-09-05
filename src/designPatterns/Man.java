package designPatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Man {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] arr=new int[n][2];

        for (int i=0;i<n;i++){
            arr[i][0]=scanner.nextInt();
            arr[i][1]=scanner.nextInt();
        }
        if(n>10){
            System.out.print(0);
            return;
        }
//        int n=4;
//        int[][] arr={{3,10},{1,3},{20,30},{2,5}};
//                int[][] arr={{2,6},{1,5},{3,7}};
        boolean shift=true;
        List<Integer> list=new ArrayList<>();
        for (int j=0;j<n;j++){
            for (int k=0;k<n;k++){
                if (k!=j){
                    for (int f=k+1;f<n;f++){
                        if (f!=j){
                            if (arr[k][1]<=arr[f][0]||arr[f][0]>=arr[k][1]){
                                shift=true;
                            }else{
                                shift=false;
                            }
                        }

                    }
                }
            }
            if (shift){
                list.add(j);
            }

        }
        System.out.println(list.size());
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+1);
        }

    }
}
