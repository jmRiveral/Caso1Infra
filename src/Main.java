import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private static  final String path ="./informacionInicio.txt";
    public static void main(String[] args) throws Exception {
        lector(path);

    }
    public void run(){

    }

    public static void lector(String d) throws Exception {

        File doc= new File(d);
        Scanner obj= new Scanner(doc);
        while (obj.hasNextLine()){
            System.out.println(obj.nextLine());
        }
    }
}