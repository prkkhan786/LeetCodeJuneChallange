import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class week2 {

    public static void main(String[] args) {
        RandomizedSet a = new RandomizedSet();
        a.insert(2);

        System.out.println(a.getRandom());

    }

}

class RandomizedSet {
    private List<Integer> data;
    private Map<Integer, Integer> hm;
    private Random rand;

    public RandomizedSet() {
        data = new ArrayList<>();
        hm = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (hm.containsKey(val)) {
            return false;
        }
        data.add(val);
        hm.put(val, data.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!hm.containsKey(val)) {
            return false;
        }

        int index = hm.get(val);
        int ele = data.get(data.size() - 1);
        data.set(index, ele);
        hm.put(ele, index);
        data.remove(data.size() - 1);
        hm.remove(val);
        return true;
    }

    public int getRandom() {
        return data.get(rand.nextInt(data.size()));

    }

}