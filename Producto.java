
public class Producto 
{
	//VARIABLES//
	int codigo;
	String producto;
	String descripcion;
	int cantidad;
	double precio;
	double iva;
	
	public Producto(int codigo, String producto, String descripcion, int cantidad, double precio, double iva)
	{
		this.codigo = codigo;
		this.producto = producto;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = precio; 
		this.iva = iva;
	}

	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}

	public void setProducto(String producto)
	{
		this.producto = producto;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public void setCantidad(int cantidad)
	{
		this.cantidad = cantidad;
	}

	public void setPrecio(double precio)
	{
		this.precio = precio;
	}

	public void setIva(double iva)
	{
		this.iva = iva;
	}

	public int getCodigo()
	{
		return codigo;
	}

	public String getProducto()
	{
		return producto;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public int getCantidad()
	{
		return cantidad;
	}

	public double getPrecio()
	{
		return precio;
	}

	public double getIva()
	{
		return iva;
	}
}
