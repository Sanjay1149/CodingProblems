package leetcode.string;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RomanIntegerToString {

    TreeMap<Integer, Character> romanMap;

    public void initializeRomanMap(List<Integer> romanValues, List<Character> romanCharacters) {
        Map<Integer, Character> tempMap = IntStream.range(0, romanValues.size()).boxed()
                .collect(Collectors.toMap(romanValues::get, romanCharacters::get));
        romanMap = new TreeMap<>(tempMap);
    }

    public String convertRomanToString(int num) {
        StringBuilder romanStringToReturn = new StringBuilder();
        int count, prevKey = 0;
        for (int i = 0; i < romanMap.size() - 1; i++) {
            int firstKey = (int) romanMap.keySet().toArray()[i];
            int secondKey = (int) romanMap.keySet().toArray()[i + 1];
            if (num >= firstKey && num < secondKey) {

                if (num % firstKey == 0) {
                    count = num / firstKey;

                    if (count == 1) {
                        romanStringToReturn.append(romanMap.get(firstKey));
                    } else if (count == 2) {
                        romanStringToReturn.append(romanMap.get(firstKey)).append(romanMap.get(firstKey));
                    } else if (count == 3) {
                        romanStringToReturn.append(romanMap.get(firstKey)).append(romanMap.get(firstKey)).append(romanMap.get(firstKey));
                    } else if (count == 4) {
                        romanStringToReturn.append(romanMap.get(firstKey)).append(romanMap.get(secondKey));
                    } else {
                        romanStringToReturn.append(romanMap.get(secondKey));
                    }
                } else {
                    count = (num - firstKey) / (secondKey / 10);

                    if (count == 1) {
                        romanStringToReturn.append(romanMap.get(firstKey)).append(romanMap.get(prevKey));
                    } else if (count == 2) {
                        romanStringToReturn.append(romanMap.get(firstKey)).append(romanMap.get(prevKey)).append(romanMap.get(prevKey));
                    } else if (count == 3) {
                        romanStringToReturn.append(romanMap.get(firstKey)).append(romanMap.get(prevKey)).append(romanMap.get(prevKey)).append(romanMap.get(prevKey));
                    } else if (count == 4) {
                        romanStringToReturn.append(romanMap.get(prevKey)).append(romanMap.get(secondKey));
                    } else {
                        romanStringToReturn.append(romanMap.get(secondKey));
                    }
                }
                break;
            }
            prevKey = firstKey;
        }
        return romanStringToReturn.toString();
    }

    public String intToRoman(int num) {
        StringBuilder romanString = new StringBuilder();

        List<Integer> romanValues = Arrays.asList(1, 5, 10, 50, 100, 500, 1000, 5000);
        List<Character> romanCharacters = Arrays.asList('I', 'V', 'X', 'L', 'C', 'D', 'M', 'V');
        initializeRomanMap(romanValues, romanCharacters);
        int romanDividend, decimal = 1;
        for (int k = 0; k < String.valueOf(num).length() - 1; k++){
            decimal *= 10;
        }

        while (num > 0) {
            romanDividend = num - ( num % decimal);
            romanString.append(convertRomanToString(romanDividend));
            num-=(num/decimal * decimal);
            decimal/=10;
        }
        return romanString.toString();
    }

    public static void main(String[] args) {
        RomanIntegerToString romanIntegerToString = new RomanIntegerToString();
        System.out.println(romanIntegerToString.intToRoman(1994));
/*        System.out.println(romanIntegerToString.convertRomanToString(100));
        System.out.println(romanIntegerToString.convertRomanToString(50));
        System.out.println(romanIntegerToString.convertRomanToString(70));
        System.out.println(romanIntegerToString.convertRomanToString(90));
        System.out.println(romanIntegerToString.convertRomanToString(100));
        System.out.println(romanIntegerToString.convertRomanToString(3000));*/
    }
}
