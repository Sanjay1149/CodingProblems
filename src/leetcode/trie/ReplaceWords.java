package leetcode.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


class ReplaceWords {

    class Node {
        int endPoint;
        Node[] next;

        Node() {
            next = new Node[26];
            endPoint = 0;
        }

    }

    Node head = new Node();

    public void createTrieStructure(List<String> dictionary) {
        for (String word : dictionary) {
            Node tempNode = head;
            char[] wordArray = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char ch = wordArray[i];
                if (tempNode.next[ch - 97] == null) {
                    tempNode.next[ch - 97] = new Node();
                }
                tempNode = tempNode.next[ch - 97];
                if (i == word.length() - 1) {
                    tempNode.endPoint = 1;
                }
            }
        }

    }

    public String getRootWordIfAny(String word) {
        Node tempNode = head;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char ch = wordArray[i];
            if (tempNode.next[ch - 97] == null) {
                break;
            }
            tempNode = tempNode.next[ch - 97];
            if (tempNode.endPoint == 1) {
                return word.substring(0, i + 1);
            }
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        createTrieStructure(dictionary);
        List<String> sentences = Arrays.stream(sentence.split(" ")).collect(Collectors.toList());
        List<String> rootSentence = new ArrayList<>(sentences.size());
        for (String word : sentences) {
            String appendingString = getRootWordIfAny(word);
            rootSentence.add(appendingString);
        }
        return rootSentence.stream().collect(Collectors.joining(" "));

        /**
         * One Efficient Solution from Discussion
         */
/*        Collections.sort(dictionary);

        return Arrays.stream(sentence.split(" ")).map(e ->
        {
            return (dictionary.stream().filter(e1 -> e.startsWith(e1) && e.contains(e1)).findFirst().orElse(e));
        }).collect(Collectors.joining(" "));*/
    }

    public static void main(String args[]) {
        ReplaceWords rw = new ReplaceWords();
        List<String> dictionary = Arrays.asList("catt", "cat", "bat", "rat");
        String searchSentence = "the cattle was rattled by the battery";
        System.out.println("Search Sentence is " + searchSentence);
        String rootSentence = rw.replaceWords(dictionary, searchSentence);
        System.out.println("Root Sentence is " + rootSentence);
    }


}