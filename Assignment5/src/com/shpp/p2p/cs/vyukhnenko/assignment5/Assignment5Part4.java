package com.shpp.p2p.cs.vyukhnenko.assignment5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.shpp.cs.a.console.TextProgram;

public class Assignment5Part4 extends TextProgram {
    /**
     * Path to the file
     */
    private static final String pathToFile = "/Users/wioletta/IdeaProjects/ShppGit/Assignment5/files/test.csv";
    /**
     * Each row of the table is represented in the CSV file as a single line,
     * with columns separated by commas.
     * The program converts the data into a standard format
     * and outputs it based on the index.
     */
    public void run() {
        extractColumn(pathToFile, 2);
    }

    /**
     * Method which converts the data into a standard format
     * and outputs it based on the index.
     *
     * @param filename String with path to file
     * @param columnIndex Number of column
     * @return
     */
    private ArrayList<String> extractColumn(String filename, int columnIndex) {
        // Read file and put it to ArrayList
        ArrayList<String> textFromFile = readFile(filename);

        if(textFromFile == null){
            return null;
        }

        // Divide elements by commas and put current line to new ArrayList currentLine,
        // using currentLine we are addressing by the index to currentLine and
        // put right element to ArrayList result
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < textFromFile.size(); i++){
            ArrayList<String> currentLine = fieldsIn(textFromFile.get(i));
            if(columnIndex >= 0 && columnIndex < currentLine.size()){
                result.add(currentLine.get(columnIndex));
            }else{
                result.add("!!Empty!!");
            }
        }
        println(result);
        return result;
    }

    /**
     * Buffer reader from the file to the ArrayList
     *
     * @param filename String which contains name of the file
     * @return ArrayList with text from the file
     */
    private ArrayList<String> readFile(String filename) {
        ArrayList<String> textFromFile = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename));){
            String line;
            while((line = br.readLine()) != null){
                textFromFile.add(line);
            }
        } catch (IOException e) {
            return null;
        }
        return textFromFile;
    }

    /**
     * Method that checks chars from the line and delete unnecessary punctuation
     * and saves necessary. Then put it to ArrayList
     *
     * @param line String with one line from the file
     * @return line divided in fields
     */
    private ArrayList<String> fieldsIn(String line) {
        ArrayList<String> fields = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();
        //Boolean if data in quotes
        Boolean inQuotes = false;

        //Cycle that checks every chr in line
        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);

            //Check if symbols in quotes, if yes put the to array, if not miss them
            if(currentChar == '"'){
                if(inQuotes && i + 1 < line.length() && line.charAt(i+1) == '"'){
                    currentWord.append('"');
                    i++;
                }else{
                    inQuotes = !inQuotes;
                }
            }else if(currentChar == ',' && !inQuotes){
                    fields.add(currentWord.toString());
                    currentWord.setLength(0);
            }else{
                currentWord.append(currentChar);
            }


        }
        fields.add(currentWord.toString());
        return fields;
    }
}


