package com.algo.string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
 
public class Anagram {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader ("C:\\Users\\Gaurav\\Documents\\words.txt");
        BufferedReader reader = new BufferedReader (fr);   
        
        Map<String, Collection<String>> anagrams = new HashMap<String, Collection<String>>();
        String word;
        int count = 0;
        while ((word = reader.readLine()) != null) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!anagrams.containsKey(key))
                anagrams.put(key, new ArrayList<String>());
            anagrams.get(key).add(word);
            count = Math.max(count, anagrams.get(key).size());
        }
 
        reader.close();
 
        for (Collection<String> ana : anagrams.values())
            if (ana.size() >= count)
                System.out.println(ana);
    }   
}