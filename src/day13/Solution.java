package day13;

import util.InputConverter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) throws IOException {
        List<String> inputs = InputConverter.convertTxtToStringList("src/day13/input-example.txt");
        List<String> coordinates = inputs.subList(0, inputs.indexOf(""));
        List<String> foldInstructions = inputs.subList(inputs.indexOf("") + 1, inputs.size());

        System.out.println(coordinates.toString());
        System.out.println(foldInstructions.toString());

        final Pattern pCoordinates = Pattern.compile("(?<x>\\d+),(?<y>\\d+)");
        final Pattern pFolds = Pattern.compile("fold along (?<axis>[xy])=(?<amount>\\d+)");
        final Matcher foldMatches = pFolds.matcher(foldInstructions.toString());
        final Matcher coordinateMatches = pCoordinates.matcher(coordinates.toString());

        while (foldMatches.find()) {
            System.out.println(foldMatches.group("axis"));
            System.out.println(foldMatches.group("amount"));
        }



        //Stap 1: deel verdeel de coördinaten en de fold instructions in twee lijsten


        //Stap 2: Bepaal max_value van X (10)* en van Y (14)*
        //* bij example
        final int MAX_VALUE_X = 10;
        final int MAX_VALUE_Y = 14;

        //Stap 3: Teken het veld
        char[][] field = new char[MAX_VALUE_Y + 1][MAX_VALUE_X + 1];


        //Stap 4: Zet de #'s neer
        while (coordinateMatches.find()) {
            int x = Integer.parseInt(coordinateMatches.group("x"));
            int y = Integer.parseInt(coordinateMatches.group("y"));
            field[y][x] = '#';

        }
        for (char[] row: field) {
            for (char x: row) {
                if(x == '#'){
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();


        //Stap 5: "Vouw" het veld
        int i = 0;
        int j = field.length - 1;
        int dots = 0;

        while (i < j){
            char[] lineUnderFold = field[j];
            char[] lineAboveFold = field[i];

            for (int x = 0; x < lineUnderFold.length; x++) {
                if (lineUnderFold[x] == '#' || lineAboveFold[x] == '#'){
                    System.out.print('#');
                } else {
                    System.out.print('.');
                    dots++;
                }
            }
            System.out.println();


            i++;
            j--;
        }
        //Stap 6: Tel de .'s

    }
}
