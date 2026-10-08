class Solution {

    Boolean[][] dp;

    public boolean makesquare(int[] matchsticks) {
        int total = 0;

        for (int i : matchsticks) {
            total += i;
        }

        if (total % 4 != 0) {
            return false;
        }

        int side = total / 4;

        Arrays.sort(matchsticks);

        dp = new Boolean[1 << matchsticks.length][side + 1];

        return getCombinations(
                matchsticks,
                side,
                0,
                0,
                0
        );
    }

    private boolean getCombinations(
            int[] matchsticks,
            int side,
            int mask,
            int sum,
            int sides) {

        if (sides == 4) {
            return mask == (1 << matchsticks.length) - 1;
        }

        if (dp[mask][sum] != null) {
            return dp[mask][sum];
        }

        for (int i = 0; i < matchsticks.length; i++) {

            if ((mask & (1 << i)) != 0) {
                continue;
            }

            int newSum = sum + matchsticks[i];

            if (newSum > side) {
                continue;
            }

            int newMask = mask | (1 << i);

            if (newSum == side) {

                if (getCombinations(
                        matchsticks,
                        side,
                        newMask,
                        0,
                        sides + 1)) {

                    return dp[mask][sum] = true;
                }

            } else {

                if (getCombinations(
                        matchsticks,
                        side,
                        newMask,
                        newSum,
                        sides)) {

                    return dp[mask][sum] = true;
                }
            }
        }

        return dp[mask][sum] = false;
    }
}