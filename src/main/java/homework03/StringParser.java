package homework03;

// Задача парсера - распарсить строку. Неважно, какая ерунда нам пришла вместо ожидаемых данных,
// парсинг всегда должен пройти без ошибок. Проверкой ошибок в данных будет заниматься валидатор.
// Еще парсер очень старается быть добрым, и прощать пользователю пропущенные (или лишние) пробелы.

public class StringParser {
    private final StringBuilder fullName = new StringBuilder();
    private final StringBuilder sbIncomingString = new StringBuilder();
    private String surname;
    private String name;
    private String patronymic;
    private final String birthday;
    private final String phoneNumber;
    private String sex;

    public StringParser(String incomingString) {
        sbIncomingString.append(incomingString);
        parsFullName(sbIncomingString);
        if (!fullName.isEmpty()) {
            surname = dismemberFullName();
            if (!fullName.isEmpty()) {
                name = dismemberFullName();
                if (!fullName.isEmpty()) {
                    patronymic = fullName.charAt(fullName.length() - 1) == ' ' ?
                                 fullName.substring(0, fullName.length() - 1) :
                                 fullName.toString();
                }
            }
        }
        birthday = parsDigits();
        phoneNumber = parsDigits();
        parsSex();
    }
    private void parsFullName(StringBuilder sbIncomingString) {
        while(sbIncomingString.length() != 0 && !Character.isDigit(sbIncomingString.charAt(0))) {
            fullName.append(sbIncomingString.charAt(0));
            sbIncomingString.deleteCharAt(0);
        }
        while (fullName.length() != 0  && fullName.charAt(0) == ' ') {
                fullName.deleteCharAt(0);
        }
    }
    private String dismemberFullName() {
        StringBuilder memberOfFullName = new StringBuilder();
        while(fullName.length() != 0 && !Character.isWhitespace(fullName.charAt(0))) {
            memberOfFullName.append(fullName.charAt(0));
            fullName.deleteCharAt(0);
        }
        while (fullName.length() != 0 && fullName.charAt(0) == ' ') {
            fullName.deleteCharAt(0);
        }
        return memberOfFullName.toString();
    }

    private String parsDigits() {
        StringBuilder sbDigits = new StringBuilder();
        while(sbIncomingString.length() != 0 && !Character.isWhitespace(sbIncomingString.charAt(0))) {
            sbDigits.append(sbIncomingString.charAt(0));
            sbIncomingString.deleteCharAt(0);
        }
        while (sbIncomingString.length() != 0 && sbIncomingString.charAt(0) == ' ') {
            sbIncomingString.deleteCharAt(0);
        }
        return sbDigits.toString();
    }
    private void parsSex() {
        if (sbIncomingString.length() != 0) {
            sex = sbIncomingString.toString();
        }
    }
    public String getSurname() {return surname;}
    public String getName() {return name;}
    public String getPatronymic() {return patronymic;}
    public String getBirthday() {return birthday;}
    public String getPhoneNumber() {return phoneNumber;}
    public String getSex() {return sex;}
}
