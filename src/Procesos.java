public class Procesos extends  Thread 
{
	private int id;
	private int tiempo;
	private boolean tipoEnvio;
	private boolean tipoRecepcion;
	private Buzon bufferBuzon;
	public Procesos(int pId,int pTiempo,boolean boolean1,boolean boolean2, Buzon buzon){
		this.id=pId;
		this.tiempo=pTiempo;
		this.tipoEnvio=boolean1;
		this.tipoRecepcion=boolean2;
		this.bufferBuzon=buzon;
	}

	public long getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getTiempo()
	{
		return tiempo;
	}

	public void setTiempo(int tiempo) 
	{
		this.tiempo = tiempo;
	}

	public boolean isTipoEnvio()
	{
		return tipoEnvio;
	}

	public boolean isTipoRecepcion()
	{
		return tipoRecepcion;
	}

	public void setTipoEnvio(boolean tipoEnvio) 
	{
		this.tipoEnvio = tipoEnvio;
	}

	public void setTipoRecepcion(boolean tipoRecepcion) 
	{
		this.tipoRecepcion = tipoRecepcion;
	}
	
	public Buzon getBufferBuzon() {
		return bufferBuzon;
	}
	
	public void setBufferBuzon(Buzon besh) {

	this.bufferBuzon=besh;
	}
	
	public void iniciar() 
	{
		
	}
}
