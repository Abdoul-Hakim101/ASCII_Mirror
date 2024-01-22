package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the file path: ");

        File file = new File(scanner.nextLine());
        try {
            Scanner fileReader = new Scanner(file);
            List<String> list = new ArrayList<>();
            while (fileReader.hasNext()) {
                list.add(fileReader.nextLine());
            }
            int max = list.stream().max(Comparator.comparing(String::length)).get().length();
            for (String line : list) {
                line += " ".repeat(max - line.length());
                String reversed = String.valueOf(new StringBuilder(line).reverse());
                char[] chars = reversed.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] == '/'){
                        chars[i] = (char) 92;
                    }else if (chars[i] == '<'){
                        chars[i] = '>';
                    }else if (chars[i] == '>'){
                        chars[i] = '<';
                    } else if (chars[i] == (char) 92){
                        chars[i] = '/';
                    }else if (chars[i] == '('){
                        chars[i] = ')';
                    }else if (chars[i] == ')'){
                        chars[i] = '(';
                    }else if (chars[i] == '{'){
                        chars[i] = '}';
                    }else if (chars[i] == '}'){
                        chars[i] = '{';
                    }else if (chars[i] == '['){
                        chars[i] = ']';
                    }else if (chars[i] == ']'){
                        chars[i] = '[';
                    }
                }
                System.out.println(line + " | " + String.valueOf(chars));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}