package homework03;

public class Main {
    public static void main(String[] args) {
        String inStr = "Belyaev Nikolay Sergeevich 30.12.1991 9215151502 m";
        StringParser strPars = new StringParser(inStr);
        System.out.println(strPars.getSurname());
        System.out.println(strPars.getName());
        System.out.println(strPars.getPatronymic());
    }
}
