package Seminar3_Homework;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter surname: ");
        String surname = scanner.next();

        System.out.print("Enter name: ");
        String name = scanner.next();

        System.out.print("Enter patronymic: ");
        String patronymic = scanner.next();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); // без этого не работало :/ гпт мне выдал про какие-то регистры MM и mm, понятия не имею что это 
        LocalDate birthDate = null;
        while (birthDate == null) {
            System.out.print("Enter birth date (dd.mm.yyyy): ");
            String input = scanner.next();
            try {
                birthDate = LocalDate.parse(input, dateFormatter);
            } catch (DateTimeParseException e) {
                System.err.println("incorrect date format. Please use dd.mm.yyyy format.");
                scanner.close();
                return;
            }
        }
        scanner.nextLine();
        long phone = 0;
        while (phone == 0) {
            System.out.print("Enter phone number:");
            try {
                phone = Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Phone number must be an unsigned integer without formatting.");
                scanner.close();
                return;
            }
        }

        char gender = ' ';
        while (gender != 'f' && gender != 'm') {

            System.out.println("Enter gender (f/m):");
            String input = scanner.nextLine();

            if (input.length() > 0) {
                gender = input.charAt(0);
            }

        }

        scanner.close();

        try {
            Person person = new Person(name, surname, patronymic, birthDate, phone, gender);
            try (FileWriter fr = new FileWriter("info.txt", true)) {
                fr.write(person.getFullName() + " " + person.getBirthDate() + " " + person.getPhone() + " "
                        + person.getGender());
                System.out.println("Data was saved!");
            } catch (IOException e) {
                // можно было бы и FileNotFound использовать
                System.out.println("Error: " + e.getMessage());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
