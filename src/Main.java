import java.io.*;
import java.util.Scanner;

public class Main {

    private static  final String path ="C:\\Users\\alejo\\OneDrive\\Documentos\\GitHub\\Caso1Infra\\src\\Data\\Inicializacion.txt";
    private static Buzon[] buzons = new Buzon[20];
    private static String[] mensajes;
    private static final String mensajesPath="C:\\Users\\alejo\\OneDrive\\Documentos\\GitHub\\Caso1Infra\\src\\Data\\Mensajes.txt";
    
    public static void main(String[] args) throws Exception
    {
    	System.out.print("Porfavor ingresar cantidad de mensajes deseados");
    	Scanner cs = new Scanner(System.in);
    	
    	int cantidad = cs.nextInt();
    	cargarMensajes(cantidad);
        File file = new File(path);
        System.out.println(file.getAbsolutePath());
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
                Procesos obj= new Procesos(Integer.parseInt(a[0]),Integer.parseInt(a[1]),Boolean.parseBoolean(a[2]),Boolean.parseBoolean(a[3]),buzons[counter-4]);
                obj.start();
                System.out.print("Proceso "+ a[0]+" creado correctamenta"+"/ln");
                System.out.println(obj.getBufferBuzon().getId());
            }
            counter++;	

        }
    }

    
    public static void cargarMensajes(int cantidad) throws Exception {
    	 

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

    public void run()
    {

    }


}