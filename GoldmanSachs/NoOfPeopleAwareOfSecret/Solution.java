package GoldmanSachs.NoOfPeopleAwareOfSecret;
// https://leetcode.com/problems/number-of-people-aware-of-a-secret/description/
class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long dp[] = new long[n+1];
        long mod = (long) 1e9 + 7;
        long noOfPeopleSharingSecret = 0;
        long ans = 0;

        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            long noOfNewPeopleSharingSecret = dp[Math.max(i-delay, 0)];
            long noOfPeopleForgetSecret = dp[Math.max(i-forget, 0)];

            noOfPeopleSharingSecret += (noOfNewPeopleSharingSecret - noOfPeopleForgetSecret + mod) % mod;

            dp[i] = noOfPeopleSharingSecret;
        }  

        for(int i = dp.length-forget; i<dp.length; i++) {
            ans = (ans + dp[i]) % mod;
        } 

        return (int)ans;
    }
}
