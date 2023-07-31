public class DataValidator {
    // Приватный конструктор, чтобы предотвратить создание экземпляров класса
    private DataValidator() {
    }

    // Метод для проверки формата фамилии
    public static void validateLastName(String lastName) throws IllegalArgumentException {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Фамилия не может быть пустой.");
        }

        // Здесь можно добавить дополнительные проверки формата фамилии, если необходимо
    }

    // Метод для проверки формата имени
    public static void validateFirstName(String firstName) throws IllegalArgumentException {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
    }

    // Метод для проверки формата отчества
    public static void validateMiddleName(String middleName) throws IllegalArgumentException {
        if (middleName == null || middleName.trim().isEmpty()) {
            throw new IllegalArgumentException("Отчество не может быть пустым.");
        }
    }

    // Метод для проверки формата даты рождения
    public static void validateBirthDate(String birthDate) throws IllegalArgumentException {
        // Пример проверки формата даты рождения (dd.mm.yyyy)
        String regex = "^(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[0-2])\\.(\\d{4})$";
        if (!birthDate.matches(regex)) {
            throw new IllegalArgumentException("Неверный формат даты рождения. Ожидается формат dd.mm.yyyy.");
        }
    }

    // Метод для проверки формата номера телефона
    public static void validatePhoneNumber(long phoneNumber) throws IllegalArgumentException {
        // Пример проверки формата номера телефона (неотрицательное целое число)
        if (phoneNumber < 0) {
            throw new IllegalArgumentException("Неверный формат номера телефона. Ожидается неотрицательное целое число.");
        }
    }

    // Метод для проверки формата пола
    public static void validateGender(char gender) throws IllegalArgumentException {
        // Пример проверки формата пола (символ латиницей f или m)
        if (gender != 'f' && gender != 'm') {
            throw new IllegalArgumentException("Неверный формат пола. Ожидается символ 'f' или 'm'.");
        }
    }
}
