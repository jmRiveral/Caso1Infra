public class Procesos extends  Thread 
{
	private int id;
	private int tiempo;
	private boolean tipoEnvio;
	private boolean tipoRecepcion;
	private Buzon buzonEnvio;
	private Buzon buzonRetiro;

	private String[] mensajes;
	public Procesos(int pId,int pTiempo,boolean boolean1,boolean boolean2, Buzon buzonEnvia,Buzon buzonRetira){
		this.id=pId;
		this.tiempo=pTiempo;
		this.tipoEnvio=boolean1;
		this.tipoRecepcion=boolean2;
		this.buzonEnvio =buzonEnvia;
		this.buzonRetiro=buzonRetira;
		this.mensajes= new String[0];
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
	
	public Buzon getBuzonEnvio() {
		return buzonEnvio;
	}
	public Buzon getBuzonRetiro() {
		return buzonRetiro;
	}
	
	public void setBuzonEnvio(Buzon besh) {

	this.buzonEnvio =besh;
	}
	public void setBuzonRetiro(Buzon besh) {

		this.buzonRetiro =besh;
	}
	public void setMensajes(String[] aCargar){
		this.mensajes=aCargar;

	}
	public void iniciar() 
	{
		
	}
}
