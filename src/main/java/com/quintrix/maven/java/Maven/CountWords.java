package com.quintrix.maven.java.Maven;


import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class CountWords {

	
	public static void main(String[] args) {
		Map<String, Integer> wordMap = new TreeMap<String,Integer>();
		try {
			BufferedReader bf = new BufferedReader(new FileReader("mobydick.txt"));
			
			
			String line = "";
			while (bf.readLine()!=null) {
				line = bf.readLine();
				
				String words[] =line.replaceAll("\\p{P}|\\'|[0-9]|\\r\n", " ").split(" ");
				for(int i=0; i<words.length;i++) {
					if(wordMap.containsKey(words[i])) {
						wordMap.put(words[i], wordMap.get(words[i])+1);
					} else {
					wordMap.put(words[i], 1);
					}
				}
				
			}
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (String key: wordMap.keySet()) {
			System.out.println(key+"\t"+wordMap.get(key));
		}
		
		List<Entry<String, Integer>> list = new LinkedList<Entry<String,Integer>>(wordMap.entrySet());
		Collections.sort(list, (o1, o2)  -> o1.getValue().compareTo(o2.getValue()));
		System.out.println(list);
		
		

	}

}
