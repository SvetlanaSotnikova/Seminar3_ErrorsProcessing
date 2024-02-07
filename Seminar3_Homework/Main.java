package Seminar3_Homework;

public class Main {
    public static void main(String[] args) {
        try {
            Runner.main(args);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
