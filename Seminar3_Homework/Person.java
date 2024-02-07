package Seminar3_Homework;

import java.time.LocalDate;
// import java.time.format.DateTimeParseException;

/*
 * Напишите приложение, которое будет запрашивать у пользователя следующие данные в указанном порядке, разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол

Форматы данных:
фамилия, имя, отчество - строки
датарождения - строка формата dd.mm.yyyy
номертелефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.
 */
public class Person {
    private String name;
    private String surname;
    private String patronymic; // отчество -_-
    private LocalDate birthDate;
    private Long phone;
    private char gender;

    public Person(String name, String surname, String patronymic, LocalDate birthDate, Long phone, char gender) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;

        
        this.birthDate = birthDate;
        this.phone = phone;
        this.gender = gender;
        
        // // корректность даты
        // try {
        //     this.birthDate = birthDate;
        // } catch (DateTimeParseException e) {
        //     throw new IllegalArgumentException("incorrenct date :(");
        // }
        
        // // корректность телеофна
        // try {
        //     this.phone = phone;
        // } catch (NumberFormatException e) {
        //     throw new IllegalArgumentException("The phone number must contain only numbers :(");
        // }

        // // корректность гендера
        // if (gender != 'f' && gender != 'm') {
        //     throw new IllegalArgumentException("Incorrect gender :()");
        // }

        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getFullName() {
        return name + " " + surname + " " + patronymic;
    }

    public String getBirthDate() {
        return birthDate.toString();
    }

    public Long getPhone() {
        return phone;
    }

    public char getGender() {
        return gender;
    }

}
