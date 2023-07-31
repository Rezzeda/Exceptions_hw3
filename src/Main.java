import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, StringBuilder> peopleByLastName = new HashMap<>(); // Используем HashMap для группировки по фамилии

        while (true) {
            try {
                System.out.println("Введите данные о человеке: Фамилия Имя Отчество Дата_рождения Номер_телефона Пол");
                String input = scanner.nextLine();

                if (input.trim().isEmpty()) {
                    // Введена пустая строка, завершаем ввод данных
                    break;
                }

                String[] data = input.split(" ");

                if (data.length != 6) {
                    throw new IllegalArgumentException("Неверное количество данных. Ожидается 6 параметров.");
                }

                String lastName = data[0];
                String firstName = data[1];
                String middleName = data[2];
                String birthDate = data[3];
                long phoneNumber = Long.parseLong(data[4]);
                char gender = data[5].charAt(0);

                // Проверка форматов данных
                DataValidator.validateLastName(lastName);
                DataValidator.validateFirstName(firstName);
                DataValidator.validateMiddleName(middleName);
                DataValidator.validateBirthDate(birthDate);
                DataValidator.validatePhoneNumber(phoneNumber);
                DataValidator.validateGender(gender);

                // Создание объекта Person
                Person person = new Person(lastName, firstName, middleName, birthDate, phoneNumber, gender);

                // Группировка по фамилии в HashMap
                if (peopleByLastName.containsKey(lastName)) {
                    StringBuilder sb = peopleByLastName.get(lastName);
                    sb.append(person.toString()).append(System.lineSeparator());
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(person.toString()).append(System.lineSeparator());
                    peopleByLastName.put(lastName, sb);
                }

                System.out.println("Данные успешно добавлены!");

            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Произошла ошибка: ");
                e.printStackTrace();
            }
        }

        // Закрытие Scanner
        scanner.close();

        // Запись данных всех однофамильцев из HashMap в файлы
        for (String lastName : peopleByLastName.keySet()) {
            try {
                StringBuilder sb = peopleByLastName.get(lastName);
                WriteToFile.writeToFile(lastName + ".txt", sb.toString());
                System.out.println("Данные успешно записаны в файл: " + lastName + ".txt");
            } catch (Exception e) {
                System.out.println("Произошла ошибка при записи в файл: " + lastName + ".txt");
                e.printStackTrace();
            }
        }
    }
}
