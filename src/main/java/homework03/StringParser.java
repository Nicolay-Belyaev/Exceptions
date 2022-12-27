package homework03;

import java.util.Date;

public class StringParser {
    private final StringBuilder fullName = new StringBuilder();
    private String surname;
    private String name;
    private String patronymic;
    private Date birthday;
    private int phoneNumber;
    private String sex;

    public StringParser(String incomingString) {
        StringBuilder sbIncomingString = new StringBuilder(incomingString);
        try {
            parsFullName(sbIncomingString);
            surname = dismemberFullName();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Имя не указано/указано неверно или нарушен формат ввода. " +
                               "Начните ввод данных c имени (+ фамилия и отчество если есть).");
        }
        if (!fullName.isEmpty()) {
            name = dismemberFullName();
        }
        if (!fullName.isEmpty()) {
            patronymic = fullName.charAt(fullName.length() - 1) == ' ' ?
                    fullName.substring(0, fullName.length() - 1) :
                    fullName.toString();
        }
        parsBirthday();
        parsPhoneNumber();
        parsSex();
    }

    private void parsFullName(StringBuilder sbIncomingstring) {
        while(!Character.isDigit(sbIncomingstring.charAt(0))) {
            fullName.append(sbIncomingstring.charAt(0));
            sbIncomingstring.deleteCharAt(0);
        }
        while (fullName.charAt(0) == ' ') {
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

    private void parsBirthday() {

    }
    private void parsPhoneNumber() {

    }
    private void parsSex() {

    }
    public String getSurname() {return surname;}
    public String getName() {return name;}
    public String getPatronymic() {return patronymic;}
}
