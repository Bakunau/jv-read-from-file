package core.basesyntax;

import java.io.*;
import java.util.Arrays;

public class FileWork {
    public String[] readFromFile(String fileName) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(" ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }

        String[] split = content.toString().split("[^a-zA-Z]+");

        int count = 0;
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (s.length() > 0 && s.toLowerCase().startsWith("w")) {
                count++;
            }
        }

        String[] result = new String[count];
        int index = 0;
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (s.length() > 0 && s.toLowerCase().startsWith("w")) {
                result[index++] = s.toLowerCase();
            }
        }

        Arrays.sort(result);

        return result;
    }
}


