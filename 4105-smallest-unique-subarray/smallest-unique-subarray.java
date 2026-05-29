class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int l = 1, r = n;
        int ans = n;

        long base = 131;
        long mod = 1000000007;

        while (l <= r) {
            int mid = (l + r) / 2;

            HashMap<Long, Integer> hm = new HashMap<>();

            long hash = 0;
            long pow = 1;

            for (int i = 0; i < mid; i++) {
                hash = (hash * base + nums[i]) % mod;
                if (i > 0) pow = (pow * base) % mod;
            }

            hm.put(hash, 1);

            for (int i = mid; i < n; i++) {
                hash = (hash - nums[i - mid] * pow % mod + mod) % mod;
                hash = (hash * base + nums[i]) % mod;

                int val = hm.getOrDefault(hash, 0);
                hm.put(hash, val + 1);
            }

            int f = 0;
            for (int val : hm.values()) {
                if (val == 1) {
                    f = 1;
                    break;
                }
            }

            if (f == 1) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}