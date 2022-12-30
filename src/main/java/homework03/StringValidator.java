package homework03;

import java.util.Scanner;

/**
 * У меня есть подозрение, что валидация данных производится не совсем так, как это делаю я.
 * Но ничего умнее я пока не придумал/не знаю.
 * <p>
 * Отдельный класс-валидатор может решать не только задачи "неккоретные данные -> выкинуть эксепшен",
 * но и задавать более сложное поведение, например править явно неправильный ввод.
 * Скажем, в нашем случае мы хотим писать в текстовый файл что-то вместо null если на ввод не пришло имя/отчество.
 * Такой подход нарушает принцип единственное ответственности.
 */

public class StringValidator {
    private final StringParser parsedString;

    public StringValidator(StringParser parsedString) {
        this.parsedString = parsedString;
        surnameValidator();
        nameValidator();
        birthdayValidator();

    }

    private void surnameValidator() {
        String surname = parsedString.getSurname();
        if (surname == null) {
            throw new NullPointerException("Ошибка ввода: данные о фамилии/имени/отчестве не введены.");
        }
        // тут могут быть проблемы с кодировкой, в которых я пока не разобрался.
        if (!surname.matches("^([A-Za-z]{2,}|[а-яА-ЯЁё]{2,})$")) {
            throw new RuntimeException("Ошибка ввода фамилии: фамилия должна содержать не менее 2-х символов" +
                                       "латиницы или кириллицы (только заглавные или строчный буквы");
        }
    }

    // TODO: можно сделать аргумент-флаг для имени и отчества и использовать интерполяцию. Или написать вторую такую же функцию для отчества.
    // TODO: но лучше вынести общение с пользователем и корректировку полей StringParser'a за пределы Validator'а.
    private void nameValidator() {
        String name = parsedString.getName();
        if (name == null) {
            Scanner comfirmationScanner = new Scanner(System.in);
            String confirmation = "";
            while (!confirmation.matches("^[yYnN]$")) {
                System.out.print("Подтвердите отсутствие имени (y/n): ");
                confirmation = comfirmationScanner.nextLine();
            }
            if (confirmation.matches("[nN]")) {
                // а сюда надо не эксепшен выдавать, а запускать программу заново, а еще лучше - просто дать пользователю указать имя через setName()
                throw new RuntimeException("Ошибка ввода имени: пожалуйста, введите данные заново.");
            }
        }
    }

    private void birthdayValidator() {
        // недостает мощи, пропускает дату вроде 30.02.2002
        if (!parsedString.getBirthday().matches("(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[012])\\.((19|20)\\d\\d)$")){
            throw new RuntimeException("Ошибка ввода даты рождения: дата рождения не введена или нарушен " +
                                       "формат ввода. Правильный формат: дд.мм.гггг");

        }
    }

    private void phoneNumberValidator() {
        if (!parsedString.getPhoneNumber().matches("^\\d{5,18}$")) {

        }
    }

    private void sexValidator() {
        if (!parsedString.getSex().matches("^[mMfF]$")) {

        }
    }


}
