package Task5;

public class MyArraySizeException extends IllegalArgumentException {
    public MyArraySizeException() {
        super("Array must be 3x3");
    }
}
