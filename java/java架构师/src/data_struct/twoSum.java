package data_struct;

import java.util.HashMap;
import java.util.Map;

public class twoSum {

    public static void main(String[] args) {
        int[] numbs={2,4,12,15};
        int target=6;
        int[] ints = twoSum(numbs, target);
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; i++) {
            Integer m = target - nums[i];
            Integer index = map.get(m);
            if (index != null) {
                result[0] = index;
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
