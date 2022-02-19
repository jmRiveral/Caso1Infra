import java.util.ArrayList;

public class Buzon 
{
    private String id;
    private int capacidad;
    private ArrayList<String> mensajes;

    public Buzon(String pId,int pcCapacidad)
    {
        this.id=pId;
        this.capacidad=pcCapacidad;
        this.mensajes = new ArrayList<String>();
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public int getCapacidad()
    {
        return capacidad;
    }

    public String getId()
    {
        return id;
    }

    public void setCapacidad(int capacidad) 
    {
        this.capacidad = capacidad;
    }
    
    public synchronized void almacenarMsj (Integer i,String msj ) throws InterruptedException
    {
    	while(mensajes.size() == capacidad)
    		wait() ;
    	
    	mensajes.add(msj);
    	notify();
    }
    
    public synchronized String retirarMsj() throws InterruptedException
    {
    	while(mensajes.size() == 0)
    		wait();
    	String msjRetirado = (String) mensajes.remove(0);
    	notify();
    	
    	return msjRetirado;
    }
    
}
