package algorithm;

import java.util.Scanner;

/**
 * Created by chensongkui on 2017/9/21.
 * 汉诺塔问题
 */
public class Hnt {
    public static void move(char source, char target, char media, int n){
        if(n==1){
            System.out.println(source+"-1-"+target);
            return ;
        }
        move(source, media, target, n-1);
        System.out.println(source+"-"+n+"-"+target);
        move(media, target, source, n-1);
    }


    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()){
            int n = cin.nextInt();
            move('A', 'C', 'B', n);
        }
    }
}
