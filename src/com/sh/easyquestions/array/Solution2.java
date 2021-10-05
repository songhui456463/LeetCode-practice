package com.sh.easyquestions.array;

/**
 * @author: songhui
 * @create: 2021-05-03 22:38
 */
public class Solution2 {

    /**
     * @description 买卖股票的最佳时机(贪心算法解法1)
     * @author songhui
     * @param prices:
     * @date 2021/5/4 14:14
     * @return: int 
     */
    public int maxProfit1(int[] prices){
        int total=0;
        if(prices==null||prices.length<2) return 0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]<prices[i+1]){
                total+=prices[i+1]-prices[i];
            }
        }
        return total;
    }


    /**
     * @description 买卖股票的最佳时机(贪心算法解法2)
     * @author songhui
     * @param prices:
     * @date 2021/5/4 14:42
     * @return: int
     */
    public int maxProfit2(int[] prices){
        if(prices==null||prices.length<2) return 0;
        int total=0,index=0,len=prices.length,min;
        while(index<len){
            while(index<len-1&&prices[index]>=prices[index+1]) index++;
            min=prices[index];
            while(index<len-1&&prices[index]<=prices[index+1]) index++;
            total+=prices[index++]-min;
        }
        return total;
    }

    /**
     * @description 动态规划
     * @author songhui
     * @param prices: 
     * @date 2021/5/7 22:58
     * @return: int 
     */
    public int maxProfit3(int[] prices){
        if(prices==null||prices.length<2) return 0;
        int len=prices.length;
        int [][]dp=new int[len][2];
        //dp[i][0]表示第i+1天的交易完手里没有股票的利润最大值
        //dp[i][1]表示第i+1天交易完手里有股票的利润最大值
        dp[0][0]=0;
        dp[0][1]-=prices[0];
        for(int i=1;i<len;i++){
            //当第i天交易完手里没有股票的状态由第i-1天没有股票的状态和第i-1天有股票但是卖了股票的状态转移过来
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //当第i天交易完手里有股票的状态由第i-1天有股票的状态和第i-1天没有股票但是买了股票的状态转移过来
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        //最后一天一定是卖了，才能获取利润的最大值
        return dp[len-1][0];
    }

    public static void main(String[] args) {
        Solution2 su=new Solution2();

    }
}
