public class Procesos extends  Thread 
{
	private int id;
	private int tiempo;
	private int cantMensajes;
	private boolean tipoEnvio;
	private boolean tipoRecepcion;
	private Buzon buzonEnvio;
	private Buzon buzonRetiro;
	private String mensaje;
	private String[] primerosMensajes;
	
	
	public Procesos(int pId, int pTiempo, boolean boolean1, boolean boolean2, Buzon buzonEnvia, Buzon buzonRetira, String[] primerosMensajesp, int pCantMensajes)
	{
		this.id=pId;
		this.tiempo=pTiempo;
		this.tipoEnvio=boolean1;
		this.tipoRecepcion=boolean2;
		this.buzonEnvio =buzonEnvia;
		this.buzonRetiro=buzonRetira;
		this.mensaje = " ";
		cantMensajes = pCantMensajes;
		primerosMensajes=new String[cantMensajes];
		primerosMensajes = primerosMensajesp;
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
	
	public Buzon getBuzonEnvio()
	{
		return buzonEnvio;
	}
	public Buzon getBuzonRetiro() 
	{
		return buzonRetiro;
	}
	
	public void setBuzonEnvio(Buzon besh) 
	{
		this.buzonEnvio =besh;
	}
	public void setBuzonRetiro(Buzon besh)
	{
		this.buzonRetiro=besh;
	}
	
	public void cambiarMensaje(String pMensaje)
	{
		mensaje = pMensaje;
	}
	
	public synchronized void darMensaje(String pMensaje) throws InterruptedException
	{
		sleep(tiempo);
		if(tipoEnvio == true)
		{
			while( this.buzonEnvio.estaLleno() != false)
					Thread.yield();
			this.buzonEnvio.anadirMensaje(pMensaje);
			System.out.println(this.id+"ActivoS"+buzonEnvio.getId());
		}
		else
		{
			this.buzonEnvio.almacenarMsjPasivo(pMensaje);
			System.out.println(this.id+"pasivoS"+buzonEnvio.getId());

		}

	}
	public synchronized void traerMensaje() throws InterruptedException
	{
		if(tipoRecepcion == true)
		{
			while( this.buzonEnvio.darMensajes().isEmpty() == true)
				Thread.yield();
			mensaje = this.buzonRetiro.darPrimerMensaje();
			System.out.println(this.id+"ActivoR"+buzonRetiro.getId());

		}
		else
		{
			mensaje = this.buzonRetiro.retirarMsj();
			System.out.println(this.id+"pasivoR"+buzonRetiro.getId());

		}
	}
	
	public synchronized void primerosMensajesLeer(int pCantidad, String[] pMensajes) throws InterruptedException
	{
		for(int i = 0; i < pMensajes.length; i ++)
		{
			mensaje = pMensajes[i];
			System.out.println("el mensaje entra al ciclo :"+mensaje);
			darMensaje(mensaje);
		}
	}
	public void run()
	{ int x= 0;
		try
		{

			if(this.id == 1  )
			{

				primerosMensajesLeer(primerosMensajes.length,primerosMensajes);
				notify();

			}

			while(mensaje.equals("FIN") != true)
			{
				darMensaje(mensaje);
				traerMensaje();
				if (this.id==4){
					System.out.println("mensaje"+x+" completo ciclo");
					x++;
				}

			}
			System.out.println("Found Fin");
			this.join();
		}	
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
