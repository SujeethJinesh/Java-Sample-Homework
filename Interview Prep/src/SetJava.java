import java.util.*;

/**
 * Created by lab on 4/5/2016.
 */
public class SetJava {
    public static void main(String[] args) {
        int[] myArray = {1, 3, 7, 7, 8, 9, 9, 9, 10};

        HashSet<Integer> set = new HashSet<>();

        for (int element: myArray) {
            set.add(element);
        }
        Integer[] sol = Arrays.copyOf(set.toArray(), set.size(), Integer[].class);

        for(int element : sol) {
            System.out.println(element);
        }
    }
}
