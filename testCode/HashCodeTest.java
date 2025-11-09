import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HashCodeTest extends ClassLoader {

    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        System.out.println(10 == 10L);

        int[] intArr = {1, 2, 3, 4, 5};
        int[] ints = twoSum(intArr, 3);
        System.out.println(Arrays.toString(ints));

    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // 如果complement存在于map中，说明找到了答案
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // 将当前数字和索引存入map
            map.put(nums[i], i);
        }

        return new int[0];
    }

}
