package normal;

import simple.多数元素;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liying
 */
public class 求众数2 {
    public static void main(String[] args) {
        求众数2 d = new 求众数2();
        d.majorityElement(new int[]{2,1});
    }

    /**
     * 摩尔投票，数1，数2，其它数 3者pk，遇到数1++，数2++，其他数分别数1--，数2--。数1与数2不抵消。
     * 假设存在数1，数2，则两者都超过n/3。其他数小于3/n
     * 那么只要数1，数2不打架，其他数来都会被抵消。
     * * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        int my = nums[0] ;
        int my2 = nums[0];
        int count = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == my) {
                count++;
            } else if (nums[i] == my2) {
                count2++;
            }
            else if (count == 0) {
                my = nums[i];
                count = 1;
            } else if (count2 == 0) {
                my2 = nums[i];
                count2 = 1;
            }else{
                count--;
                count2--;
            }
        }
        int mysize = 0;
        int my2size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == my) {
                mysize++;
            } else if (nums[i] == my2) {
                my2size++;
            }
        }
        List<Integer> list = new ArrayList<>();
        if (mysize > nums.length / 3) {
            list.add(my);
        }
        if (my2size > nums.length / 3) {
            list.add(my2);
        }

        return list;
    }
}
