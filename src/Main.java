import java.io.*;
import java.util.Scanner;

public class Main {

    private static  final String path ="...\\Data\\Inicializacion.txt";
    private static Buzon[] buzons = new Buzon[20];
    
    
    public static void main(String[] args) throws Exception
    {
        File file = new File(path);      
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int counter=0;
        while ((st = br.readLine()) != null){
            if (counter<4) 
            {
                String[] a = st.split(" ");
                buzons[counter]= new Buzon(a[0],Integer.parseInt(a[1]));
            }
            else  
            {
                String[] a = st.split(" ");
                Procesos obj= new Procesos(Integer.parseInt(a[0]),Integer.parseInt(a[1]),Boolean.parseBoolean(a[2]),Boolean.parseBoolean(a[3]));
                obj.start();
                System.out.println(obj.getId());
            }
            counter++;	

        }
    }


    public void run()
    {

    }


}