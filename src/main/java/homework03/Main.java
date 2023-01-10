package homework03;

public class Main {
    public static void main(String[] args) {
        String inStr = "Petrov 30.02.1991 9215151502 M";

        StringParser strParts = new StringParser(inStr);
        StringValidator validator = new StringValidator(strParts);
        StringWriter writer = new StringWriter(strParts);
    }
}
