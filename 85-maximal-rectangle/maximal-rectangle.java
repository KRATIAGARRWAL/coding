class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] arr = new int[n];
        int ans = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') arr[j] = 0;
                else arr[j]++;
            }

            int[] stk = new int[n + 1];
            int top = -1;

            for (int j = 0; j <= n; j++) {
                int h = (j == n) ? -1 : arr[j];

                while (top != -1 && h < arr[stk[top]]) {
                    int height = arr[stk[top--]];
                    int width = (top == -1) ? j : j - stk[top] - 1;
                    ans = Math.max(ans, height * width);
                }

                stk[++top] = j;
            }
        }

        return ans;
    }
}
