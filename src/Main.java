import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static  final String path ="C:\\Users\\Josué\\Documents\\Proyectos\\Caso1\\src\\Data\\Inicializacion.txt";
    private static ArrayList<Buzon> buzons = new ArrayList<Buzon>();
    private static String[] mensajes;
    private static final String mensajesPath="C:\\Users\\Josué\\Documents\\Proyectos\\Caso1\\src\\Data\\Mensajes.txt";
    
    public static void main(String[] args) throws Exception
    {
    	System.out.print("Porfavor ingresar cantidad de mensajes deseados");
    	Scanner cs = new Scanner(System.in);
    	int cantidad = cs.nextInt();
    	cargarMensajes(cantidad);
        inicioDePrograma();
    }

    public static void inicioDePrograma() throws Exception
    {
    	File file = new File(path);
        System.out.println(file.getAbsolutePath());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int counter=0;
        int x=1;
        while ((st = br.readLine()) != null){
            if (counter<4) 
            {
                String[] a = st.split(" ");
                Buzon anadir = new Buzon(a[0], Integer.parseInt(a[1]));
                buzons.add(anadir);


            }
            else  
            {
                System.out.println(counter);
                System.out.println(buzons.get(counter-4).getId());
                String[] a = st.split(" ");
                if (x==1) {
                    Procesos obj = new Procesos(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Boolean.parseBoolean(a[2]), Boolean.parseBoolean(a[3]), buzons.get(counter-4), buzons.get(3-x));
                }
                //obj.start();
                x++;
            }
            counter++;	

        }
    }
    public static void cargarMensajes(int cantidad) throws Exception 
    {
    	 

    	File file = new File(mensajesPath);
        System.out.println();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        mensajes= new String[cantidad];
        int counter = 0;
        while ((st = br.readLine()) != null && counter!=cantidad){
          mensajes[counter]=st;
          System.out.print("mensaje:"+st+" cargado \n");
          counter++;
        }
                
    }



}