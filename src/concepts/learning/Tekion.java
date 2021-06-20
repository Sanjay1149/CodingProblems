package concepts.learning;

import java.util.Scanner;

public class Tekion {
    public static void main(String args[]) {

        Scanner in =  new Scanner(System.in);
        String original = in.nextLine();
        String searchWord = in.nextLine();
        int searchWordLen = searchWord.length();
        int searchCount = 0;

        boolean valueFound = false;
        int indexStart = 0;
        for(int i=0; i<original.length(); i++){
            if ( original.charAt(i) == searchWord.charAt(searchCount) ) {
                if ( searchCount == 0 ) {
                    indexStart = i;
                }
                searchCount++;
            } else {
                searchCount = 0;
                i--;
            }


            if ( searchCount == searchWordLen ) {
                valueFound = true;
                break;
            }
        }

        if(valueFound) {
            System.out.println("Value Found at " + indexStart);
        } else{
            System.out.println("Value Not Found");
        }
    }
}
