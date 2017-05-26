/**
 * Created by yyt on 2017/5/25.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static ArrayList<Integer> mylist;
    public static ArrayList<Integer> mymap;
    public static int tempbiggers;
    public static void add(int x, int mod ,int last_Q,int count_I) {
        int res = (x+last_Q) % mod;
        mylist.add(res);
    }
    public static void add2(int x, int mod ,int last_Q,int count_I) {
        int res = (x+last_Q) % mod;
        mylist.add(res);
        res = Math.max(res,tempbiggers);
        if (count_I % 1000==0){
            mymap.add(res);
            tempbiggers = 0;
        }
        else{
            tempbiggers = res;
        }
    }
    public static int query2(int x) {
        int length = mylist.size();
        int res = -10;


        int a2 = (length-x) / 1000;
        int a3 = length/1000;
        int a4 = length % 1000;
        if (a2+1 < a3){
            for (int i = length-x; i < (a2+1)*1000 ;i++){
                res =Math.max(res,mylist.get(i));
            }
            for(int i= a2+1;i <= a3;i++) {
                res = Math.max(res,mymap.get(i-1));
            }
            if (a4 != 0){
                res =Math.max(res,tempbiggers);
            }

        }else if(a2+1 ==a3){
            for (int i = length-x; i < (a2+1)*1000 ;i++){
                res =Math.max(res,mylist.get(i));
            }
            if (a4 != 0){
                res =Math.max(res,tempbiggers);
            }

        }
        else {
            for (int i = length-x; i < length; i++) {
                try {
                    res = Math.max(res, mylist.get(i));
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            System.out.print(res);
        }

        return res;
    }
    public static int query(int x) {
        int length = mylist.size();
        int res = -10;
        for (int i = length-x; i < length ;i++){
            res =Math.max(res,mylist.get(i));
        }

        return res;
    }

    public static void main(String[] args){
        mylist = new ArrayList<Integer>();
        mymap = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int mod = in.nextInt();
        int last_Q = 0;

        int count_I = 0;
        if(m > 2000){
            while(m-- > 0){
                String ch = in.next();
                int x = in.nextInt();

                if(ch.equals("I")){
                    count_I++;
                    add2(x,mod,last_Q,count_I);

                } else {
                    last_Q = query2(x);
                    System.out.println(last_Q);

                }
            }
        }else{
            while(m-- > 0){
                String ch = in.next();
                int x = in.nextInt();

                if(ch.equals("I")){
                    count_I++;
                    add(x,mod,last_Q,count_I);

                } else {
                    last_Q = query(x);
                    System.out.println(last_Q);

                }
            }
        }
    }
}
