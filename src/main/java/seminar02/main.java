package seminar02;

import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        try {
            FileReader wr = new FileReader("src/main/java/seminar02/text.txt");
            int c;
            while ((c=wr.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}