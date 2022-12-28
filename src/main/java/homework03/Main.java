package homework03;

public class Main {
    public static void main(String[] args) {
        String inStr = "Belyaev Nick Serg 30.12.1991 9215151502 M";

        StringParser strParts = new StringParser(inStr);
        System.out.println(strParts.getSurname());
        System.out.println(strParts.getName());
        System.out.println(strParts.getPatronymic());
        System.out.println(strParts.getBirthday());
        System.out.println(strParts.getPhoneNumber());
        System.out.println(strParts.getSex());
    }
}
