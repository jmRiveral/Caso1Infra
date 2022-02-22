import java.util.ArrayList;

public class Buzon
{
    private String id;
    private int capacidad;
    private ArrayList<String> mensajes;

    public Buzon(String pId, int pCapacidad)
    {
        this.id=pId;
        this.capacidad=pCapacidad;
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

    public ArrayList<String> darMensajes()
    {
    	return mensajes;
    }
    
    public String darPrimerMensaje()
    {
		return mensajes.get(0);
    	
    }
    public void setCapacidad(int capacidad) 
    {
        this.capacidad = capacidad;
    }
    
    public synchronized void anadirMensaje(String mensaje)
    {
    	mensajes.add(mensaje);
    	notify();
    }
    public boolean estaLleno()
    {
    	return (mensajes.size() == capacidad);
    }
    public synchronized void almacenarMsjPasivo(String msj) throws InterruptedException
    {
    	while(estaLleno() != false)
    		wait() ;
    	
    	mensajes.add(msj);
    	notify();
    }
    
    public synchronized String retirarMsj() throws InterruptedException
    {
    	while(mensajes.isEmpty() == true)
    		wait();
    	String msjRetirado = (String) mensajes.remove(0);
    	notify();
    	
    	return msjRetirado;
    }
    
}
