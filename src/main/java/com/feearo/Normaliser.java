package com.feearo;
import java.util.Arrays;
import java.util.List;

public class Normaliser {

    private final List<String> normalizedTitles = Arrays.asList("Architect", "Software engineer", "Quantity surveyor", "Accountant");
    
    public Normaliser() {
    }

    public String normalise(String inputTitle) {
        String bestMatch = null;
        int minDistance = Integer.MAX_VALUE;

        for (String title : normalizedTitles) {
            int distance = levenshteinDistance(title.toLowerCase(), inputTitle.toLowerCase());
            if (distance < minDistance) {
                minDistance = distance;
                bestMatch = title;
            }
        }

        return bestMatch;
    }

    // Levenshtein distance calculation
    private int levenshteinDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= s2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
            }
        }

        return dp[s1.length()][s2.length()];	
    }

    public static void main(String[] args) {
        String jt = "Java engineer"; 
        Normaliser n = new Normaliser(); 
        String normalisedTitle = n.normalise(jt); 
        //output normalisedTitle 
        jt = "C# engineer"; 
        normalisedTitle = n.normalise(jt); 
        System.out.println(jt + " > " + normalisedTitle);

        jt = "Java engineer"; 
        normalisedTitle = n.normalise(jt); 
        System.out.println(jt + " > " + normalisedTitle);

        //output normalisedTitle 
        jt = "Accountant"; 
        normalisedTitle = n.normalise(jt); 
        System.out.println(jt + " > " + normalisedTitle);

        jt = "Chief Accountant"; 
        normalisedTitle = n.normalise(jt); 
        System.out.println(jt + " > " + normalisedTitle);


    }
}