package homework03;

public class StringValidator {
    StringParser parsedString;

    public StringValidator(StringParser parsedString) {
        surnameValidator();
        birthdayValidator();
        phoneNumberValidator();
    }

    private void surnameValidator() {
        if (parsedString.getSurname() == null) {}
    }

    private void birthdayValidator() {
        if (!parsedString.getBirthday().matches("(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[012])\\.((19|20)\\d\\d)")) {}
    }

    private void phoneNumberValidator() {
        if (parsedString.getPhoneNumber()) {}
    }

    private void sexValidator() {
        String sex = parsedString.getSex();
        if (!(sex.equals("f") || sex.equals("m"))) {}
    }


}
