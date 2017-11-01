package basics.losAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumSet {
    static ArrayList<ArrayList<Integer>> sum_up_recursive(
            List<Integer> numbers,
            int target,
            ArrayList<Integer> partial,
            ArrayList<ArrayList<Integer>> result) {
        int s = 0;
        for (int x: partial) s += x;
        if (s == target)
            result.add(partial);
        if (s >= target)
            return result;
        for(int i=0;i<numbers.size();i++) {
            ArrayList<Integer> remaining = new ArrayList<>();
            int n = numbers.get(i);
            for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
            ArrayList<Integer> partial_rec = new ArrayList<>(partial);
            partial_rec.add(n);
            sum_up_recursive(remaining,target,partial_rec, result);
        }
        return result;
    }
    public static ArrayList<ArrayList<Integer>> sum_up(List<Integer> numbers, int target) {
       return sum_up_recursive(numbers,target,new ArrayList<>(), new ArrayList<>());
    }

    public static void main(String args[]) {
        Integer[] numbers = {3,9,8,4,5,7,10};
        int target = 15;
        ArrayList<ArrayList<Integer>> res = sum_up(new ArrayList<>(Arrays.asList(numbers)),target);
        for(int i=0;i<res.size();i++) {
            ArrayList<Integer> n = res.get(i);
            System.out.println("sum("+Arrays.toString(n.toArray())+")="+target);
        }
    }
}
