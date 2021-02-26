package simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liying
 */
public class 多数元素 {
    public static void main(String[] args) {
        多数元素 d = new 多数元素();
        d.majorityElement2(new int[]{3, 2, 3});
    }

    /**
     * map存储
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) return entry.getKey();
        }
        ;
        return 0;
    }

    /**
     * 摩尔投票
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int my = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                my = nums[i];
            }
            if (nums[i] == my) {
                count++;
            } else {
                count--;
            }
        }
        return my;
    }
}
