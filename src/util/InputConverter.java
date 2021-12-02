package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class InputConverter {

    public static List<Integer> convertTxtToIntegerList(String path) throws IOException {
        try (BufferedReader bf = new BufferedReader(new FileReader(path))){
            return bf.lines().map(Integer::parseInt).collect(Collectors.toList());
        }
    }

    public static List<String> convertTxtToStringList(String path) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(path));
        return bf.lines().collect(Collectors.toList());
    }

}
