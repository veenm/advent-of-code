package day3;

import util.InputConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        //part 1
        List<String> input = InputConverter.convertTxtToStringList("src/day3/input.txt");


        int[] gammaIntegers = Solution.calculateBit(input);
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();



        System.out.println(Arrays.toString(gammaIntegers));

        for (int gammaInteger: gammaIntegers) {
            if(gammaInteger > input.size() / 2){
                gamma.append("1");
                epsilon.append("0");
            } else {
                gamma.append("0");
                epsilon.append("1");
            }
        }
        System.out.println(Integer.parseInt(gamma.toString(), 2));
        System.out.println(Integer.parseInt(epsilon.toString(), 2));

        System.out.println(Integer.parseInt(gamma.toString(), 2) * Integer.parseInt(epsilon.toString(), 2));

        //part 2
        System.out.println(Integer.parseInt(Solution.findRating(new ArrayList<>(input), 0), 2));
        System.out.println(Integer.parseInt(Solution.findRatingLeast(new ArrayList<>(input), 0), 2));




    }

    public static String findRating(List<String> input, int i){
        int[] gammaIntegers = Solution.calculateBit(input);

        if(input.size() == 1){
            return input.get(0);
        }

        else if(input.isEmpty()){
            throw new IllegalStateException("Dude, wtf heb je gedaan?!!?!?!?!");
        }



        if(gammaIntegers[i] >= Math.ceil(Double.parseDouble(Integer.toString(input.size())) / 2d)) {
            input.removeIf(in -> in.charAt(i) != '1');
        } else {
            input.removeIf(in -> in.charAt(i) != '0');
        }

        return findRating(input, i + 1);

    }

    public static String findRatingLeast(List<String> input, int i){
        int[] gammaIntegers = Solution.calculateBit(input);

        if(input.size() == 1){
            return input.get(0);
        }

        else if(input.isEmpty()){
            throw new IllegalStateException("Dude, wtf heb je gedaan?!!?!?!?!");
        }


        if(gammaIntegers[i] < Math.ceil(Double.parseDouble(Integer.toString(input.size())) / 2d)){
            input.removeIf(in -> in.charAt(i) != '1');
        } else {
            input.removeIf(in -> in.charAt(i) != '0');
        }

        return findRatingLeast(input, i + 1);

    }

    public static int[] calculateBit(List<String> input){
        int[] gammaIntegers = new int[12];

        for (String line: input) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '1'){
                    gammaIntegers[i] = gammaIntegers[i] + 1;
                }
            }
        }
        return gammaIntegers;
    }



}
