package ru.mail.gasimov20177.reader;



import ru.mail.gasimov20177.exception.ConvertNumberException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class CustomFileReader {
    public String readFromFile(String filePath) throws ConvertNumberException {
        try {
            Path path = Path.of(filePath);

            return Files.readString(path);
        } catch (InvalidPathException | IOException e) {
            throw new ConvertNumberException("Unable to open file: " + filePath, e);
        }
    }
}
