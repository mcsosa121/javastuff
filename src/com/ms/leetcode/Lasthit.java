package com.ms.leetcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem

 Diana needs your help maximizing her gold while playing her favorite game.
 She is often faced with a scenario where she is standing close to her tower and is facing N monsters.
 When that happens, Diana and the tower take turns shooting the monsters, and she goes first.
 During her turn, Diana may choose a monster to shoot at (this means Diana may choose to skip a turn).
 During its turn, the tower shoots the monster closest to it. Diana and the tower can not shoot dead monsters.

 If Diana shoots at a monster, its hit points are reduced by P. If the tower shoots at a monster,
 its hit points are reduced by Q. If a monster's hit points are reduced below 1, it is killed.
 The ith monster starts with Hi hit points. Diana is awarded Gi gold if her shot kills the ith monster,
 but none if the tower's shot kills it. What is the maximum amount of gold Diana can obtain?

 Input

 The first line of the input gives the number of test cases, T. T test cases follow.
 Each case begins with one line containing three space-separated integers representing P, Q and N. N lines then follow,
 with the ith line containing two space-separated integers representing Hi and Gi.

 The monsters are given in the order of their distance from the tower. In other words, the tower will shoot at the
 ith monster only if all monsters < i are dead.

 Output

 For each test case, output one line containing "Case #x: y", where x is the case number (starting from 1) and y is the
 maximum amount of gold that Diana can obtain.

 Limits

 1 ≤ T ≤ 100
 20 ≤ P ≤ 200
 20 ≤ Q ≤ 200
 1 ≤ Hi ≤ 200
 0 ≤ Gi ≤ 106
 Small dataset

 1 ≤ N ≤ 4

 Large dataset

 1 ≤ N ≤ 100

 Sample


 Input
 2
 20 40 3
 100 100
 20 100
 60 100
 20 60 3
 80 100
 80 200
 120 300

 Output
 Case #1: 300
 Case #2: 500

 In the second example, Diana should give up the first monster. During her first two turns she should soften up the
 third monster bringing it down to 80 hp, allowing her to easily get the last shot on the second and the third monsters.
 */
public class Lasthit {
    static int[] h = new int[107];
    static int[] g = new int[107];
    static int[][][] dp = new int[107][207][1007];
    static int p,q,n;

    public static void main(String[] sa) {

        // Small
        helper("src/com/ms/leetcode/Tests/Lasthitsmall.txt");
        // Large
        // helper("src/com/ms/leetcode/Tests/Lasthitlarge.txt");

    }

    public static void helper(String filen) {
        int t, i, j, k, ans;

        try (BufferedReader br = new BufferedReader(new FileReader(filen))) {
            t = Integer.parseInt(br.readLine());

            for (int l=1; l <= t; l++) {
                String[] arr = br.readLine().split(" ");
                p = Integer.parseInt(arr[0]);
                q = Integer.parseInt(arr[1]);
                n = Integer.parseInt(arr[2]);

                for(i=0; i < n; i++) {
                    arr = br.readLine().split(" ");
                    h[i] = Integer.parseInt(arr[0]);
                    g[i] = Integer.parseInt(arr[1]);
                }

                for (i = 0; i < 107; i++) {
                    for (j = 0; j < 207; j++) {
                        for (k = 0; k < 1007; k++) {
                            dp[i][j][k] = -1;
                        }
                    }
                }

                ans = recurrance(0, h[0], 1);
                System.out.println("Case:" + l + ": " + ans);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }

    public static int recurrance(int i, int j, int k) {
        if (j < 1 && i == n-1)
            return 0;

        if (j < 1)
            return recurrance(i,j-q, k+1);

        if(dp[i][j][k] != -1)
            return dp[i][j][k];

        int ans = recurrance(i, j - q, k + 1), gEarned;

        if (k == 1) {
            if (j<=p)
                gEarned = g[i];
            else
                gEarned = 0;

            ans = Math.max(ans, gEarned + recurrance(i, j - p, k - 1));

        }

        return dp[i][j][k] = ans;
    }

}
