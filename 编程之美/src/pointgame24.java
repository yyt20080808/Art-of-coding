import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by yyt on 2017/5/25.
 */
public class pointgame24 {
    public static ArrayList<HashSet> S;
    public static void  main(String args[]){
        int[] input = {1,2,3,4};
        Game(input);
    }
    public static void Game(int []array){
        int length = array.length;
        S = new ArrayList<HashSet>();
        // 可以 Math.pow
        for(int i =1;i<= 1 <<length -1;i++){
            S.add(new HashSet());
        }
        for(int i = 0;i<length;i++){
            S.get((1<<i)).add(array[i]);
        }
        for (int i =1;i < 2<<length-1;i++){
            S.set(i,f(i));
        }
//        S.get(5).add(1);
//        S.get(5).set(0,2);
//        System.out.println(S.get(5).get(0));
    }
    public static HashSet f(int i){
        // 防止重复行为
        if(S.get(i).size()> 0){
            return S.get(i);
        }
        HashSet temp = S.get(i);

        // 否则重新新建一个了



        return temp;
    }
}
