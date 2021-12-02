package day2;

import util.InputConverter;

import java.io.IOException;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        List<String> instructions = InputConverter.convertTxtToStringList("src/day2/input.txt");
        int depth = 0;
        int horizontal = 0;
        int aim = 0;

        for (String instruction: instructions) {
            if(instruction.contains("forward")) {
                horizontal = horizontal + Integer.parseInt(instruction.substring(8));
            }

            else if(instruction.contains("up")) {
                depth = depth - Integer.parseInt(instruction.substring(3));
            }

            else if(instruction.contains("down")) {
                depth = depth + Integer.parseInt(instruction.substring(5));
            }
        }

        System.out.println("Solution 1: ");
        System.out.println("Depth = " + depth);
        System.out.println("Horizontal = " + horizontal );
        System.out.println("Anwser = " + depth * horizontal + "\n"); //new line for design purposes

        depth = 0;
        horizontal = 0;

        //part 2
        for (String instruction: instructions) {
           if(instruction.contains("forward")) {
                horizontal = horizontal + Integer.parseInt(instruction.substring(8));
                depth = depth + (aim * Integer.parseInt(instruction.substring(8)));
           }

           else if(instruction.contains("up")) {
               aim = aim - Integer.parseInt(instruction.substring(3));
           }

           else if(instruction.contains("down")) {
               aim = aim + Integer.parseInt(instruction.substring(5));
           }
        }

        System.out.println("Solution 2:");
        System.out.println("Depth = " + depth);
        System.out.println("Horizontal = " + horizontal);
        System.out.println("Aim = " + aim);

        System.out.println("Anwser = " + depth * horizontal);

    }
}
