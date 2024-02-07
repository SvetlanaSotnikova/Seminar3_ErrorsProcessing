
import java.io.IOException;

/**
 * Создайте класс Счетчик, у которого есть метод add(), увеличивающий значение
 * внутренней int переменной на 1. Сделайте так, чтобы с объектом такого типа
 * можно было работать в блоке try-with-resources. Подумайте, что должно
 * происходить
 * при закрытии этого ресурса? Напишите метод для проверки, закрыт ли ресурс.
 * При попытке вызвать add() у закрытого ресурса, должен выброситься IOException
 */

public class Counter implements AutoCloseable {
    int in = 0;
    boolean closed = false;

    public void add() throws IOException {
        if (closed) {
            throw new IOException("Resource is closed");
        }
        in++;
    }

    @Override
    public void close() throws Exception {
        if (!closed) {
            closed = true;
        }
    }

    public int getIn() {
        return in;
    }

    public boolean isClosed() {
        return closed;
    }

    /**
     * Main
     */
    public class Main {
        public static void main(String[] args) throws Exception {
            try (Counter counter = new Counter()) {
                System.out.println(counter.getIn());
                counter.add();
                System.out.println(counter.getIn());
                counter.add();
            }

            // System.out.println(counter.getIn());
            // counter.add();
            // counter.close();
            // counter.add();
        }
    }
}
