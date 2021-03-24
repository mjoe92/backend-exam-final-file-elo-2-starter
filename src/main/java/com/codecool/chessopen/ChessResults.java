package com.codecool.chessopen;

import java.io.*;
import java.util.*;

public class ChessResults {

    public List<String> getCompetitorsNamesFromFile(String fileName){
        File file = new File(fileName);
        List<String> lines = new ArrayList<>();
        List<String> results = new ArrayList<>();
        Map<String, Integer> calculatedResults = new HashMap<>();
        try {
            Scanner reader = new Scanner(file, "UTF-8");
            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
            reader.close();
            for (String line : lines) {
                List<String> all = Arrays.asList(line.split(","));
                int sum = 0;
                for (int i = 1; i <= 5; i++) {
                    sum += Integer.parseInt(all.get(i));
                }
                calculatedResults.put(all.get(0), sum);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        List<Integer> sortedList = new ArrayList<>(calculatedResults.values());
        sortedList.sort(Collections.reverseOrder());
        for (Integer result : sortedList) {
            for (String name : calculatedResults.keySet()) {
                if (calculatedResults.get(name).equals(result)) {
                    results.add(name);
                    calculatedResults.remove(name);
                    break;
                }
            }
        }
        return results;
    }

}
