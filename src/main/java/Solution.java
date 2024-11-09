import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> numberFrequency = new HashMap<>();
        for (int num : nums1) {
            numberFrequency.merge(num, 1, Integer::sum);
        }

        List<Integer> intersection = new ArrayList<>();
        for (int num : nums2) {
            int frequency = numberFrequency.getOrDefault(num, 0);
            if (frequency > 0) {
                intersection.add(num);
                numberFrequency.put(num, frequency - 1);
            }
        }

        int[] result = new int[intersection.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = intersection.get(i);
        }
        return result;
    }
}