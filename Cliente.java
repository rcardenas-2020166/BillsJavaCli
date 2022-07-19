
public class Cliente
{
	//VARIABLES//
	int codigoCliente;
	String nombreCliente;
	String apellidoCliente;
	String nit;

	public Cliente(int codigoCliente, String nombreCliente, String apellidoCliente, String nit)	
	{
		this.codigoCliente = codigoCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.nit = nit; 
	}

	public void setCodigo(int codigoCliente)
	{
		this.codigoCliente = codigoCliente;
	}

	public void setNombre(String nombreCliente)
	{
		this.nombreCliente = nombreCliente;
	}

	public void setApellido(String apellidoCliente)
	{
		this.apellidoCliente = apellidoCliente;
	}

	public void setNit(String nit)
	{
		this.nit = nit;
	}

	public int getCodigo()
	{
		return codigoCliente;
	}

	public String getNombre()
	{
		return nombreCliente;
	}

	public String getApellido()
	{
		return apellidoCliente;
	}

	public String getNit()
	{
		return nit;
	}
}
