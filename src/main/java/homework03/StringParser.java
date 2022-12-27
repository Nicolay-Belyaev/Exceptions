package homework03;

import java.util.Date;

public class StringParser {
    public  StringBuilder fullName = new StringBuilder();
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
            name = dismemberFullName();
            patronymic = fullName.substring(0, fullName.length() - 1).toString();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Имя не указано/указано неверно или нарушен формат ввода. " +
                               "Начните ввод данных c имя (+ фамилия и отчество если есть).");
        }
        parsBirthday();
        parsPhoneNumber();
        parsSex();
    }

    private void parsFullName(StringBuilder sbIncomingstring) {
        int charIndex = 0;
        while(!Character.isDigit(sbIncomingstring.charAt(charIndex))) {
            fullName.append(sbIncomingstring.charAt(charIndex));
            charIndex++;
        }
        while (fullName.charAt(0) == ' ') {
            fullName.deleteCharAt(0);
        }
        sbIncomingstring.delete(0, fullName.length());
    }
    private String dismemberFullName() {
        StringBuilder memberOfFullName = new StringBuilder();
        while(!Character.isWhitespace(fullName.charAt(0))) {
            memberOfFullName.append(fullName.charAt(0));
            fullName.deleteCharAt(0);
        }
        while (fullName.charAt(0) == ' ') {
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
