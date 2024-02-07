package Task3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task3 {
    public static void main(String[] args) {
        // System.out.println(divide(5, 0));
        try {
            fileNotFound("wwe");
        } catch (NonExistedFileException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int divide(int a, int b) throws DivideByZeroException {
        if (b == 0) {
            throw new DivideByZeroException();
        }
        return a / b;
    }

    static void fileNotFound(String path) throws IOException {
        try (FileReader fr = new FileReader(path)) {
        } catch (FileNotFoundException e) {
            throw new NonExistedFileException();
        }
    }
}
