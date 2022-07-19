
public class Factura 
{

	//VARIABLES//
	int codigoFactura;
	String nitCliente;
	String nombreCliente;
	String apellidoCliente;
	String producto1;
	int cantidad1;
	double precio1;
	double iva1;
	String producto2;
	int cantidad2;
	double precio2;
	double iva2;
	String producto3;
	int cantidad3;
	double precio3;
	double iva3;
	double subtotal;
	double total;

	public Factura(int codigoFactura, String nitCliente,String nombreCliente, String apellidoCliente,
		String producto1, int cantidad1, double precio1, double iva1,
		String producto2, int cantidad2, double precio2, double iva2,
		String producto3, int cantidad3, double precio3, double iva3, 
		double subtotal, double total)
	{
		this.codigoFactura = codigoFactura;
		this.nitCliente = nitCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.producto1 = producto1;
		this.cantidad1 = cantidad1;
		this.precio1 = precio1;
		this.iva1 = iva1;
		this.producto2 = producto2;
		this.cantidad2 = cantidad2;
		this.precio2 = precio2;
		this.iva2 = iva2;
		this.producto3 = producto3;
		this.cantidad3 = cantidad3;
		this.precio3 = precio3;
		this.iva3 = iva3;
		this.subtotal = subtotal;
		this.total = total;
	}

	public int getCodigoFactura()
	{
		return codigoFactura;
	}

	public void setCodigoFactura()
	{
		this.codigoFactura = codigoFactura; 
	}

	public String getNitCliente()
	{
		return nitCliente;
	}

	public void setNitCliente()
	{
		this.nitCliente = nitCliente;
	}

	public String getNombreCliente()
	{
		return nombreCliente;
	}

	public void setNombreCliente()
	{
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente()
	{
		return apellidoCliente;
	}

	public void setApellidoCliente()
	{
		this.apellidoCliente = apellidoCliente;
	}


	public String getProductoUno()
	{
		return producto1;
	}

	public void setProductoUno()
	{
		this.producto1 = producto1;
	}

	public int getCantidadUno()
	{
		return cantidad1;
	}

	public void setCantidadUno()
	{
		this.cantidad1 = cantidad1;
	}

	public double getPrecioUno()
	{
		return precio1;
	}

	public void setPrecioUno()
	{
		this.precio1 = precio1;
	}

	public double getIvaUno()
	{
		return iva1;
	}

	public String getProductoDos()
	{
		return producto2;
	}

	public void setProductoDos()
	{
		this.producto2 = producto2;
	}

	public int getCantidadDos()
	{
		return cantidad2;
	}

	public void setCantidadDos()
	{
		this.cantidad2 = cantidad2;
	}

	public double getPrecioDos()
	{
		return precio2;
	}

	public void setPrecioDos()
	{
		this.precio2 = precio2;
	}

	public double getIvaDos()
	{
		return iva2;
	}

	public String getProductoTres()
	{
		return producto3;
	}

	public void setProductoTres()
	{
		this.producto3 = producto3;
	}

	public int getCantidadTres()
	{
		return cantidad3;
	}

	public void setCantidadTres()
	{
		this.cantidad3 = cantidad3;
	}

	public double getPrecioTres()
	{
		return precio3;
	}

	public void setPrecioTres()
	{
		this.precio3 = precio3;
	}

	public double getIvaTres()
	{
		return iva3;
	}

	public double getSubTotalCompra()
	{
		return subtotal;
	}

	public void setSubTotalCompra()
	{
		this.subtotal = subtotal;
	}

	public double getTotalCompra()
	{
		return total;
	}

	public void setTotalCompra()
	{
		this.total = total;
	}
}
