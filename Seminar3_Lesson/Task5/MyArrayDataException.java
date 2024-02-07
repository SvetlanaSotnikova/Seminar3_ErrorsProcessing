package Task5;

import java.util.List;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int i, int j) {
        super(String.format("In cell [%s][%s] has invalid data", i, j));
    }

    public MyArrayDataException(List<Point2d> points) {
        super(String.format("In cells [%s] has invalid data", points));
    }
}
