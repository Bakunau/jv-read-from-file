package core.basesyntax;

import java.io.*;

public class FileWork {
    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int value;
            while ((value = reader.read()) != -1) {
                builder.append((char) value);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }

        String[] split = builder.toString().split("\\W+");

        int count = 0;
        for (String s : split) {
            if (!s.isEmpty() && s.toLowerCase().startsWith("w")) {
                count++;
            }
        }

        String[] result = new String[count];
        int index = 0;

        for (String s : split) {
            if (!s.isEmpty() && s.toLowerCase().startsWith("w")) {
                result[index++] = s.toLowerCase();
            }
        }

        return result;
    }
}

