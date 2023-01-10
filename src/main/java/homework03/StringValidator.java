package homework03;

import java.util.Scanner;

/**
 * У меня есть подозрение, что валидация данных производится не совсем так, как это делаю я.
 * Но ничего умнее я пока не придумал/не знаю.
 * <p>
 * Отдельный класс-валидатор может решать не только задачи "неккоретные данные -> выкинуть эксепшен",
 * но и задавать более сложное поведение, например, страховать пользователя не лишая программу гибкости поведения.
 * Скажем, в нашем случае мы хотим переспросить пользователя, точно ли в данных нет имени/отчества, а если да,
 * то писать в текстовый файл что-то вместо null.
 * В каком-то смысле, такой подход нарушает принцип единственной ответственности, но где та тонкая грань...
 */

public class StringValidator {
    private final StringParser parsedString;

    public StringValidator(StringParser parsedString) {
        this.parsedString = parsedString;
        surnameValidator();
        nameValidator();
        patronymicValidator();
        birthdayValidator();
        phoneNumberValidator();
        sexValidator();
        dataOverFlowValidator();
    }

    private void surnameValidator() {
        String surname = parsedString.getSurname();
        if (surname == null) {
            throw new NullPointerException("Ошибка ввода: данные о фамилии/имени/отчестве не введены.");
        }
        // тут могут быть проблемы с кодировкой, в которых я пока не разобрался.
        // надо проверить двойные фамилии, вроде Салтыков-Щедрин.
        if (!surname.matches("^([A-Za-z]{2,}|[а-яА-ЯЁё]{2,})$")) {
            throw new RuntimeException("Ошибка ввода фамилии: фамилия должна содержать не менее 2-х символов" +
                                       "латиницы или кириллицы (только заглавные или строчный буквы).");
        }
    }

    private void nameValidator() {
        String name = parsedString.getName();
        if (name == null) {
            nameOfPatronymicCheckAndSet("имя");
        } else if ((!name.matches("^([A-Za-z]{2,}|[а-яА-ЯЁё]{2,})$"))) {
            throw new RuntimeException("Ошибка ввода фамилии: имя (если есть) должно содержать не менее 2-х символов\n" +
                                       "латиницы или кириллицы (только заглавные или строчный буквы");
        }
    }

    private void patronymicValidator() {
        String patronymic = parsedString.getPatronymic();
        if (patronymic == null) {
            nameOfPatronymicCheckAndSet("отчество");
        // проверить отчества, состоящие из 2 и более слов, всякие Оглы, Кызы и т.п.
        } else if ((!patronymic.matches("^([A-Za-z]{2,}|[а-яА-ЯЁё]{2,})$"))) {
            throw new RuntimeException("Ошибка ввода фамилии: имя (если есть) должно содержать не менее 2-х символов\n" +
                    "латиницы или кириллицы (только заглавные или строчный буквы");
        }
    }

    private void nameOfPatronymicCheckAndSet(String nameOrPatronymic) {
        Scanner scanner = new Scanner(System.in);
        String confirmation = "";
        while (!confirmation.matches("^[yYnN]$")) {
            System.out.print(nameOrPatronymic + " отсутствует? (y/n): ");
            confirmation = scanner.nextLine();
        }
        if (confirmation.matches("[nN]")) {
            System.out.print("Введите " + nameOrPatronymic + ": ");
            if (nameOrPatronymic.equals("имя")) {
                parsedString.setName(scanner.nextLine());
                nameValidator();
            } else {
                parsedString.setPatronymic(scanner.nextLine());
                patronymicValidator();
            }
        } else {
            parsedString.setName("-");
        }
    }

    private void birthdayValidator() {
        // недостает мощи, пропускает дату вроде 30.02.2002
        if (!parsedString.getBirthday().matches("(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[012])\\.((19|20)\\d\\d)$")){
            throw new RuntimeException("Ошибка ввода даты рождения: дата рождения не введена или нарушен " +
                                       "формат ввода.\nПравильный формат: дд.мм.гггг");
        }
    }

    private void phoneNumberValidator() {
        if (!parsedString.getPhoneNumber().matches("^\\d{5,18}$")) {
            throw new RuntimeException("Ошибка ввода телефона: телефон не введен или нарушен формат ввода.\n" +
                                       "Правильный формат: от 5 до 18 символов, только числа без форматирования");
        }
    }

    private void sexValidator() {
        if (!parsedString.getSex().matches("^[mMfF]$")) {
            throw new RuntimeException("Ошибка ввода пола: пол не введен или нарушен формат ввода." +
                                       "Правильный формат ввода: латинские строчный или заглавные буквы F или M");
        }
    }

    private void dataOverFlowValidator() {
        if (!parsedString.getFullName().isEmpty()) {
            throw new RuntimeException("Ошибка ввода данных: введено слишком много данных. Проверить входящую строку");
        }
    }


}
