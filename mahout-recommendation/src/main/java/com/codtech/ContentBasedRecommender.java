package com.codtech;

import java.io.*;
import java.util.*;

public class ContentBasedRecommender {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your interests (comma separated):");
        System.out.println("1. Electronics");
        System.out.println("2. Clothing");
        System.out.println("3. Home");
        System.out.println("4. Books");
        System.out.println("5. Fitness");
        System.out.println("6. Beauty");
        System.out.println("7. Food & Grocery");
        System.out.println("8. Gaming");

        System.out.print("Enter your choices (e.g., 1,4,6): ");
        String input = scanner.nextLine();
        scanner.close();

        Map<String, String> interestMap = new HashMap<>();
        interestMap.put("1", "electronics");
        interestMap.put("2", "clothing");
        interestMap.put("3", "home");
        interestMap.put("4", "books");
        interestMap.put("5", "fitness");
        interestMap.put("6", "beauty");
        interestMap.put("7", "food");
        interestMap.put("8", "gaming");

        Set<String> selectedTags = new HashSet<>();
        for (String choice : input.split(",")) {
            choice = choice.trim();
            if (interestMap.containsKey(choice)) {
                selectedTags.add(interestMap.get(choice));
            }
        }

        class ItemInfo {
            String name;
            String tag;
            ItemInfo(String name, String tag) {
                this.name = name;
                this.tag = tag;
            }
        }

        Map<String, ItemInfo> itemInfoMap = new HashMap<>();
        Map<String, Set<String>> tagItemsMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/item_tags.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String itemID = parts[0];
                    String itemName = parts[1];
                    String tag = parts[2];
                    itemInfoMap.put(itemID, new ItemInfo(itemName, tag));
                    tagItemsMap.computeIfAbsent(tag, k -> new HashSet<>()).add(itemID);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        Set<String> recommendations = new HashSet<>();
        for (String tag : selectedTags) {
            recommendations.addAll(tagItemsMap.getOrDefault(tag, new HashSet<>()));
        }

        
        System.out.println("\nRecommendations based on your interests:");
        try (PrintWriter writer = new PrintWriter("recommendations.txt")) {
            for (String itemID : recommendations) {
                ItemInfo info = itemInfoMap.get(itemID);
                if (info != null) {
                    String result = "Recommend item: " + info.name + " (Tag: " + info.tag + ")";
                    System.out.println(result);
                    writer.println(result);
                }
            }
            System.out.println("\n Recommendations saved to recommendations.txt");
        } catch (IOException e) {
            System.err.println(" Failed to write to recommendations.txt");
            e.printStackTrace();
        }
    }
}
