class Solution {
    public int[] makeParityAlternating(int[] nums) {
        int n = nums.length;
        if(n == 1) return new int[]{0, 0};

        int costA = 0, costB = 0;

        int diffA = getMinDiff(nums, true);
        int diffB = getMinDiff(nums, false);

        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                if(nums[i] % 2 != 0) costA++;
                if(nums[i] % 2 == 0) costB++;
            } else {
                if(nums[i] % 2 == 0) costA++;
                if(nums[i] % 2 != 0) costB++;
            }
        }

        if(costA < costB) return new int[]{costA, diffA};
        if(costB < costA) return new int[]{costB, diffB};
        return new int[]{costA, Math.min(diffA, diffB)};
    }

    private int getMinDiff(int[] nums, boolean patternA) {
        int n = nums.length;

        List<int[]> candidates = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int x = nums[i];
            boolean needEven = patternA ? (i % 2 == 0) : (i % 2 != 0);

            if((x % 2 == 0) == needEven) {
                candidates.add(new int[]{x, i});
            } else {
                candidates.add(new int[]{x - 1, i});
                candidates.add(new int[]{x + 1, i});
            }
        }

        candidates.sort((a, b) -> Integer.compare(a[0], b[0]));

        int[] count = new int[n];
        int covered = 0;
        int left = 0;
        int ans = Integer.MAX_VALUE;

        for(int right = 0; right < candidates.size(); right++) {
            int idx = candidates.get(right)[1];
            if(count[idx] == 0) covered++;
            count[idx]++;

            while(covered == n) {
                int diff = candidates.get(right)[0] - candidates.get(left)[0];
                ans = Math.min(ans, diff);

                int leftIdx = candidates.get(left)[1];
                count[leftIdx]--;
                if(count[leftIdx] == 0) covered--;
                left++;
            }
        }

        return ans;
    }
}