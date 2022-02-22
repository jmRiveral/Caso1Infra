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
    	cargarMensajes();
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
                buzons.add(new Buzon(a[0],Integer.parseInt(a[1])));
            }
            else  
            {
                String[] a = st.split(" ");
                if (x==1) {
                    Procesos obj = new Procesos(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Boolean.parseBoolean(a[2]), Boolean.parseBoolean(a[3]), buzons.get(0), buzons.get(buzons.size()-1));
                    obj.start();
                }else{
                    Procesos obj = new Procesos(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Boolean.parseBoolean(a[2]), Boolean.parseBoolean(a[3]), buzons.get(counter-4), buzons.get(counter-5));
                    obj.start();
                    System.out.print("Proceso "+ a[0]+" creado correctamente con buzones: "+buzons.get(counter-4).getId()+","+ buzons.get(counter-5).getId());
                }

                x++;





            }
            counter++;	

        }
    }
    public static void cargarMensajes() throws Exception 
    {
    	System.out.print("Porfavor ingresar cantidad de mensajes deseados");
    	Scanner cs = new Scanner(System.in);
    	int cantidad = cs.nextInt();
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