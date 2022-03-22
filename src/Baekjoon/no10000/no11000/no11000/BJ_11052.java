package Baekjoon.no10000.no11000.no11000;

import java.util.Scanner;

public class BJ_11052 {
    private static class Card{
        int idx;
        int cost;
        double unit;

        public Card(int idx, int cost, double unit) {
            this.idx = idx;
            this.cost = cost;
            this.unit = unit;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Card[] cards = new Card[N];
        int cost;

        for (int i = 0; i < N; i++) {
            cost = sc.nextInt();
            cards[i] = new Card(i + 1, cost, (cost / (double)(i + 1)));
        }

        int[] dp = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < N; j++) {
                if (i + cards[j].idx <= N) {
                    dp[i + cards[j].idx] = Math.max(dp[i + cards[j].idx], dp[i] + cards[j].cost);
                }
            }
        }

        System.out.println(dp[N]);
    }
}
