package day4;

import util.InputConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> input = InputConverter.convertTxtToStringList("src/day4/input.txt");
        List<String> bingoNumbers = numberSlicer(input);
        List<String> bingoCard = getBingoCard(input);

        System.out.println(input.toString());
        System.out.println(bingoNumbers.toString());
        System.out.println(bingoCard.toString());


        System.out.println(bingoChecker(bingoCard, bingoNumbers).toString());


    }

    public static List<String> numberSlicer(List<String> input) {
        String firstLine = input.get(0);
        input.remove(0);
        input.remove(0);
        List<String> numbers = Arrays.asList(firstLine.split(","));
        return numbers;
    }

    public static List<String> getBingoCard(List<String> input) {
        List<String> bingoCard = input.subList(0, 5);
        return bingoCard;
    }

    public static List<String> rowValidator(List<String> input){

        return input;
    }

    public static List<String> bingoChecker(List<String> bingoCard, List<String> bingoNumbers) {
        List<String> newBingoCard = new ArrayList<>();
        List<String> row;
        List<String> newRow = new ArrayList<>();
        int numbersPassed = 0;
        int rowIndex = 0;

        for (int i = 0; i < 5; i++) {
            row = rowValidator(Arrays.asList(bingoCard.get(i).split(" ")));
            System.out.println(row);
            for (String number : bingoNumbers) {
                for (String cardNumber : row) {
                    if (cardNumber.equals(number)) {
                        row.set(rowIndex, "X");
                    }
                    numbersPassed++;
                    rowIndex++;
                    if (numbersPassed == bingoNumbers.size()) {
                        newRow.add(String.valueOf(row));
                        newBingoCard.addAll(newRow);
                        newRow.clear();
                        numbersPassed = 0;
                    }
                }
                rowIndex = 0;
            }
        }


        return newBingoCard;
    }

}
