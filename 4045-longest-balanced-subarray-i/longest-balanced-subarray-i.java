class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;

        // Coordinate compression
        int[] a = nums.clone();
        Arrays.sort(a);
        Map<Integer, Integer> id = new HashMap<>();
        int idx = 0;
        for (int x : a)
            if (!id.containsKey(x))
                id.put(x, idx++);

        int blocks = (idx + 63) >> 6;
        long[] even = new long[blocks];
        long[] odd  = new long[blocks];

        int ans = 0;

        for (int l = 0; l < n; l++) {
            Arrays.fill(even, 0);
            Arrays.fill(odd, 0);

            for (int r = l; r < n; r++) {
                int c = id.get(nums[r]);
                int b = c >> 6;
                int bit = c & 63;

                if ((nums[r] & 1) == 0)
                    even[b] |= 1L << bit;
                else
                    odd[b] |= 1L << bit;

                int ce = 0, co = 0;
                for (int i = 0; i < blocks; i++) {
                    ce += Long.bitCount(even[i]);
                    co += Long.bitCount(odd[i]);
                }

                if (ce == co)
                    ans = Math.max(ans, r - l + 1);
            }
        }
        return ans;
    }
}
