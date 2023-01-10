package homework03;

/**
 Задача парсера - распарсить строку.
 Неважно, какая ерунда нам пришла вместо ожидаемых данных, парсинг должен пройти без ошибок.
 Проверкой ошибок в данных будет заниматься валидатор.
 Еще парсер очень старается быть добрым и прощать пользователю пропущенные (или лишние) пробелы.
 Кроме того, автор парсера встречался в своей биографии как с людьми, у которых нет не только отчества, но и фамилии,
 т.е. их "ID" состояло из 1 слова, так и тех, у кого полное имя состоит из, скажем, 4 частей.
 Поэтому он наделил парсер способностью спокойно относиться к таким случая. Что не по ТЗ, конечно, ага.
 **/

public class StringParser {
    private final StringBuilder fullName = new StringBuilder();
    private String surname;
    private String name;
    private String patronymic;
    private String birthday;
    private String phoneNumber;
    private String sex;

    public StringParser(String incomingString) {
        StringBuilder sbIncomingString = new StringBuilder(incomingString);
        parsFullName(sbIncomingString);
        if (!fullName.isEmpty()) {
            surname = stringBuilderChooper(fullName);
            if (!fullName.isEmpty()) {
                name = stringBuilderChooper(fullName);
                if (!fullName.isEmpty()) {
                    patronymic = stringBuilderChooper(fullName);
                }
            }
        }
        birthday = stringBuilderChooper(sbIncomingString);
        phoneNumber = stringBuilderChooper(sbIncomingString);
        sex = stringBuilderChooper(sbIncomingString);
    }
    private void parsFullName(StringBuilder sbIncomingString) {
        while(sbIncomingString.length() != 0 && !Character.isDigit(sbIncomingString.charAt(0))) {
            fullName.append(sbIncomingString.charAt(0));
            sbIncomingString.deleteCharAt(0);
        }
        removeSpaceFromHead(fullName);
    }

    private String stringBuilderChooper(StringBuilder target) {
        StringBuilder partOfStringBuilder = new StringBuilder();
        while(target.length() != 0 && !Character.isWhitespace(target.charAt(0))) {
            partOfStringBuilder.append(target.charAt(0));
            target.deleteCharAt(0);
        }
        removeSpaceFromHead(target);
        return partOfStringBuilder.toString();
    }

    private void removeSpaceFromHead(StringBuilder target) {
        while (target.length() != 0 && target.charAt(0) == ' ') {
            target.deleteCharAt(0);
        }
    }

    public void setName(String name) {this.name = name;}
    public void setPatronymic(String patronymic) {this.patronymic = patronymic;}
    public StringBuilder getFullName() {return fullName;}
    public String getSurname() {return surname;}
    public String getName() {return name;}
    public String getPatronymic() {return patronymic;}
    public String getBirthday() {return birthday;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getSex() {return sex;}
}
