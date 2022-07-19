
import java.util.ArrayList;
import java.math.RoundingMode;
public class ControladorProducto
{
	//VARIABLES//
	String producto;
	String descripcion;
	int cantidad;
	double precio;
	double iva;
	int otorgaCodigo = 100;
	int codigo;
	int contador = 0;
	int conteo;
	int eleccionNumero;

	
	ObtenerDatos oD = new ObtenerDatos();
	static ArrayList <Producto> arregloProducto = new ArrayList<Producto>();

	//ESTO ME RETORNA TODOS LOS CAMBIOS QUE SE REALICEN EN EL ARRAY//
	public ArrayList <Producto> getArrayProducto()
	{
		return arregloProducto;
	}

	//INGRESAR PRODUCTOS//
	public void ingresarProducto()
	{
		System.out.println("\n ESCRIBA EL NOMBRE DEL PRODUCTO ");
		System.out.print(" ");
		producto = oD.texto();				
			
		System.out.println(" AGREGUE UNA DESCRIPCION PARA EL PRODUCTO ");
		System.out.print(" ");
		descripcion = oD.texto();
		
		System.out.println(" ESCRIBA LA CANTIDAD DE UNIDADES DEL PRODUCTO ");
		System.out.print(" ");
		cantidad = oD.numero();

		System.out.println(" ESCRIBA EL PRECIO INDIVIDUAL DEL PRODUCTO ");
		System.out.println(" *NOTA : EL PRECIO DEBE SER EN QUETZALES");
		System.out.print(" ");
		precio = oD.decimal();
		iva = (precio*12)/100;	
		otorgaCodigo++;
		arregloProducto.add(new Producto(otorgaCodigo,producto,descripcion,cantidad,precio,iva));
		reporteProducto();
		while(contador==arregloProducto.size())
		{	
			otorgaCodigo++;
		}
		contador++;
	}

	//REPORTE DE PRODUCTOS//
	public void reporteProducto()
	{
		int i=arregloProducto.size();
		conteo = 0;
		if (i>0)
		{	
			System.out.println("\n--------------------------------------");
			System.out.println(" *PRODUCTOS REGISTRADOS* ");
			System.out.println("--------------------------------------");
			for (i = 0; i<arregloProducto.size(); i++)
			{
				System.out.println(" CODIGO : P-"+arregloProducto.get(i).getCodigo());
				System.out.println(" PRODUCTO : "+arregloProducto.get(i).getProducto());
				System.out.println(" DESCRIPCION : "+arregloProducto.get(i).getDescripcion());
				System.out.println(" CANTIDAD : "+arregloProducto.get(i).getCantidad()+" unidades ");
				System.out.println(" PRECIO : Q."+arregloProducto.get(i).getPrecio());
				System.out.println(" IVA x UNIDAD: Q."+ (double)Math.round(arregloProducto.get(i).getIva()*100d)/100);
				System.out.println("--------------------------------------");
				conteo++;
			}
		}
		 else if (conteo==0)
			{
				System.out.println("\n NO HAY DATOS ");
				System.out.println(" |INGRESE PRODUCTOS PARA CONTINUAR| ");
			}
	}

	//BUSCAR PRODUCTOS//
	public void buscarProducto()
	{			
		contador = 0;
		System.out.println("\n ESCRIBA EL CODIGO DEL PRODUCTO ");
		System.out.print(" P-");
		codigo = oD.numero();
		for ( int i = 0; i < arregloProducto.size(); i++ )
		{
			if (codigo==arregloProducto.get(i).getCodigo())
			{
				System.out.println("\n--------------------------------------");
				System.out.println(" *PRODUCTO ENCONTRADO* ");
				System.out.println("--------------------------------------");
				System.out.println(" CODIGO : P-"+arregloProducto.get(i).getCodigo());
				System.out.println(" PRODUCTO : "+arregloProducto.get(i).getProducto());
				System.out.println(" DESCRIPCION : "+arregloProducto.get(i).getDescripcion());
				System.out.println(" CANTIDAD : "+arregloProducto.get(i).getCantidad()+" unidades ");
				System.out.println(" PRECIO : Q."+arregloProducto.get(i).getPrecio());
				System.out.println(" IVA x UNIDAD: Q."+ (double)Math.round(arregloProducto.get(i).getIva()*100d)/100);
				System.out.println("--------------------------------------");
				contador++;
			}
		}

		if (contador==0)
		{
			System.out.println("\n |BUSQUEDA SIN EXITO| *PRODUCTO NO ENCONTRADO* ");
		}
	}

	//MODIFICAR PRODUCTOS//
	public void modificarProducto()
	{
		int i = arregloProducto.size();
		System.out.println("\n INGRESE EL CODIGO DEL PRODUCTO ");
		System.out.print(" P-");
		codigo = oD.numero();
		if(i==0)
		{
			System.out.println("\n  NO HAY DATOS ");
			System.out.println(" |INGRESE PRODUCTOS PARA MODIFICAR| ");
		}
		
		else
		{
			contador = 0;
			for (  i = 0; i < arregloProducto.size(); i++ )
			{
				if (codigo==arregloProducto.get(i).getCodigo())
				{	
					do
					{
						conteo=0;
						System.out.println("\n--------------------------------------");
						System.out.println(" *PRODUCTO A MODIFICAR* ");
						System.out.println("--------------------------------------");
						System.out.println(" CODIGO : P-"+arregloProducto.get(i).getCodigo());
						System.out.println(" PRODUCTO : "+arregloProducto.get(i).getProducto());
						System.out.println(" DESCRIPCION : "+arregloProducto.get(i).getDescripcion());
						System.out.println(" CANTIDAD : "+arregloProducto.get(i).getCantidad()+" unidades ");
						System.out.println(" PRECIO : Q."+arregloProducto.get(i).getPrecio());
						System.out.println(" IVA x UNIDAD: Q."+ (double)Math.round(arregloProducto.get(i).getIva()*100d)/100);
						System.out.println("--------------------------------------\n");
						System.out.println(" |MENU DE MODIFICACIONES| ");
						System.out.println("  1 -> Modificar Nombre ");
						System.out.println("  2 -> Modificar Descripcion ");
						System.out.println("  3 -> Modificar Cantidad ");
						System.out.println("  4 -> Modificar Precio "); 
						System.out.println("\n Seleccione una Opcion ");
						System.out.print(" ");
						eleccionNumero = oD.numero();
						switch(eleccionNumero)
						{
							case 1:
								System.out.println("\n INGRESE EL NUEVO NOMBRE PARA EL PRODUCTO ");
								System.out.print(" ");
								producto = oD.texto();
								arregloProducto.get(i).setProducto(producto);
								System.out.println("\n--------------------------------------");
								System.out.println(" *PRODUCTO MODIFICADO* ");
								System.out.println("--------------------------------------");
								System.out.println(" CODIGO : P-"+arregloProducto.get(i).getCodigo());
								System.out.println(" PRODUCTO : "+arregloProducto.get(i).getProducto());
								System.out.println(" DESCRIPCION : "+arregloProducto.get(i).getDescripcion());
								System.out.println(" CANTIDAD : "+arregloProducto.get(i).getCantidad()+" unidades ");
								System.out.println(" PRECIO : Q."+arregloProducto.get(i).getPrecio());
								System.out.println(" IVA x UNIDAD: Q."+ (double)Math.round(arregloProducto.get(i).getIva()*100d)/100);
								System.out.println("--------------------------------------");
								break;

							case 2:
								System.out.println("\n INGRESE LA NUEVA DESCRIPCION PARA EL PRODUCTO ");
								System.out.print(" ");
								descripcion = oD.texto();
								arregloProducto.get(i).setDescripcion(descripcion);
								System.out.println("\n--------------------------------------");
								System.out.println(" *PRODUCTO MODIFICADO* ");
								System.out.println("--------------------------------------");
								System.out.println(" CODIGO : P-"+arregloProducto.get(i).getCodigo());
								System.out.println(" PRODUCTO : "+arregloProducto.get(i).getProducto());
								System.out.println(" DESCRIPCION : "+arregloProducto.get(i).getDescripcion());
								System.out.println(" CANTIDAD : "+arregloProducto.get(i).getCantidad()+" unidades ");
								System.out.println(" PRECIO : Q."+arregloProducto.get(i).getPrecio());
								System.out.println(" IVA x UNIDAD: Q."+ (double)Math.round(arregloProducto.get(i).getIva()*100d)/100);
								System.out.println("--------------------------------------");
								break;

							case 3:
								System.out.println("\n INGRESE LA NUEVA CANTIDAD PARA EL PRODUCTO ");
								System.out.print(" ");
								cantidad = oD.numero();
								arregloProducto.get(i).setCantidad(cantidad);
								System.out.println("\n--------------------------------------");
								System.out.println(" *PRODUCTO MODIFICADO* ");
								System.out.println("--------------------------------------");
								System.out.println(" CODIGO : P-"+arregloProducto.get(i).getCodigo());
								System.out.println(" PRODUCTO : "+arregloProducto.get(i).getProducto());
								System.out.println(" DESCRIPCION : "+arregloProducto.get(i).getDescripcion());
								System.out.println(" CANTIDAD : "+arregloProducto.get(i).getCantidad()+" unidades ");
								System.out.println(" PRECIO : Q."+arregloProducto.get(i).getPrecio());
								System.out.println(" IVA x UNIDAD: Q."+ (double)Math.round(arregloProducto.get(i).getIva()*100d)/100);
								System.out.println("--------------------------------------");
								break;

							case 4:
								System.out.println("\n INGRESE EL NUEVO PRECIO PARA EL PRODUCTO ");
								System.out.println(" *NOTA : EL PRECIO DEBE SER EN QUETZALES");
								System.out.print(" ");
								precio = oD.decimal();
								arregloProducto.get(i).setPrecio(precio);
								iva = (precio*12)/100;
								arregloProducto.get(i).setIva(iva);
								System.out.println("\n--------------------------------------");
								System.out.println(" *PRODUCTO MODIFICADO* ");
								System.out.println("--------------------------------------");
								System.out.println(" CODIGO : P-"+arregloProducto.get(i).getCodigo());
								System.out.println(" PRODUCTO : "+arregloProducto.get(i).getProducto());
								System.out.println(" DESCRIPCION : "+arregloProducto.get(i).getDescripcion());
								System.out.println(" CANTIDAD : "+arregloProducto.get(i).getCantidad()+" unidades ");
								System.out.println(" PRECIO : Q."+arregloProducto.get(i).getPrecio());
								System.out.println(" IVA x UNIDAD: Q."+ (double)Math.round(arregloProducto.get(i).getIva()*100d)/100);
								System.out.println("--------------------------------------");
								break;	


							default:
								System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
								System.out.println(" VUELVA A INTENTARLO !  ");
								conteo=1;
								break;		
						}
					}	while(conteo==1);
						contador = 1;			
						break;//ROMPE EL IF	
				}
						
			}if(contador==0)
				{
					System.out.println("\n |EL CODIGO INGRESADO NO EXISTE| ");
				}
			}		
		}

	//ELIMINAR PRODUCTOS//
	public void eliminarProducto()
	{
		int i = arregloProducto.size();
		contador = 0;
		System.out.println("\n INGRESE EL CODIGO DEL PRODUCTO ");
		System.out.print(" P-");
		codigo = oD.numero();
		if (i==0)
		{
			System.out.println("\n NO HAY DATOS ");
			System.out.println(" |INGRESE PRODUCTOS PARA ELIMINAR| ");
		}else
		{
			conteo =0;
			for( i = 0; i < arregloProducto.size(); i++)
			{
				if(codigo==arregloProducto.get(i).getCodigo())
				{
					do
					{	
						System.out.println("\n--------------------------------------");
						System.out.println(" *PRODUCTO A ELIMINAR* ");
						System.out.println("--------------------------------------");
						System.out.println(" CODIGO : "+arregloProducto.get(i).getCodigo());
						System.out.println(" PRODUCTO : "+arregloProducto.get(i).getProducto());
						System.out.println(" DESCRIPCION : "+arregloProducto.get(i).getDescripcion());
						System.out.println(" CANTIDAD : "+arregloProducto.get(i).getCantidad()+" unidades ");
						System.out.println(" PRECIO : Q."+arregloProducto.get(i).getPrecio());
						System.out.println(" IVA x UNIDAD: Q."+ (double)Math.round(arregloProducto.get(i).getIva()*100d)/100);
						System.out.println("--------------------------------------\n");
						System.out.println(" Seguro que desea eliminar al PRODUCTO...");
						System.out.println(" 1 -> ELIMINAR ");
						System.out.println(" 2 -> CONSERVAR ");
						System.out.print(" ");
						eleccionNumero=oD.numero();
						if(eleccionNumero==1)
						{
							arregloProducto.remove(i);
							System.out.println("\n PRODUCTO ELIMINADO CORRECTAMENTE ");
							reporteProducto();
						}
						else if(eleccionNumero==2)
						{
							System.out.println("\n SE CONSERVO EL PRODUCTO ");
							reporteProducto();
						}
						else
						{
							System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
							System.out.println(" VUELVA A INTENTARLO !  ");
						}
						conteo=1;
					}	while ((eleccionNumero!=1)&&(eleccionNumero!=2));
				break;
				}
			}
			if (conteo==0)
			{
				System.out.println("\n |EL CODIGO INGRESADO NO EXISTE| ");
			}
		}
	}

	//PRODUCTO FACTURA//
	public void buscarProductoFactura(int codigo)
	{			
		contador = 0;
		for ( int i = 0; i < arregloProducto.size(); i++ )
		{
			if (codigo==arregloProducto.get(i).getCodigo())
			{
				System.out.println("\n--------------------------------------");
				System.out.println(" *PRODUCTO* ");
				System.out.println("--------------------------------------");
				System.out.println(" CODIGO : P-"+arregloProducto.get(i).getCodigo());
				System.out.println(" PRODUCTO : "+arregloProducto.get(i).getProducto());
				System.out.println(" DESCRIPCION : "+arregloProducto.get(i).getDescripcion());
				System.out.println(" PRECIO : Q."+arregloProducto.get(i).getPrecio());
				System.out.println(" IVA x UNIDAD: Q."+ (double)Math.round(arregloProducto.get(i).getIva()*100d)/100);
				System.out.println("--------------------------------------\n");
				contador++;
			}
		}
	}
}	
