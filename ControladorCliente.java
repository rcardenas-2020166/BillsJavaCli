
import java.util.ArrayList;
public class ControladorCliente
{
	//VARIABLES//
	String nombre;
	String apellido;
	String nit;
	int otorgaCodigo = 10000;
	int codigo;
	int contador=0;
	int conteo;
	int eleccionNumero;

	ObtenerDatos oD = new ObtenerDatos();

	static ArrayList <Cliente> arregloCliente = new ArrayList<Cliente>();

	//ESTO ME RETORNA TODOS LOS CAMBIOS QUE SE REALICEN EN EL ARRAY//
	public ArrayList <Cliente> getArrayCliente()
	{
		return arregloCliente;
	}
	
	//INGRESAR CLIENTES//
	public void ingresarCliente()
	{
		System.out.println("\n INGRESE EL NOMBRE DEL CLIENTE ");
		System.out.print(" ");
		nombre = oD.texto();	

		System.out.println(" INGRESE EL APELLIDO DEL CLIENTE ");
		System.out.print(" ");	
		apellido = oD.texto();
									
		System.out.println(" ESCRIBA EL NIT DEL CLIENTE ");
		System.out.print(" ");
		nit = oD.texto();

		otorgaCodigo++;
		arregloCliente.add(new Cliente(otorgaCodigo, nombre, apellido, nit));
		reporteCliente();
		while(contador==arregloCliente.size())
		{	
			otorgaCodigo++;
		}
		contador++;
	}

	//REPORTE CLIENTES//
	public void reporteCliente()
	{ 
		int i=arregloCliente.size();
		conteo = 0;
		if (i>0)
		{	
			System.out.println("\n-------------------------");
			System.out.println(" *CLIENTES REGISTRADOS* ");
			System.out.println("-------------------------");
			for (i = 0; i<arregloCliente.size(); i++)
			{
				System.out.println(" ID : C-"+arregloCliente.get(i).getCodigo());
				System.out.println(" NOMBRE : "+arregloCliente.get(i).getNombre());
				System.out.println(" APELLIDO : "+arregloCliente.get(i).getApellido());
				System.out.println(" NIT : "+arregloCliente.get(i).getNit());
				System.out.println("-------------------------");
				conteo++;
			}
		}
		 else if (conteo==0)
			{
				System.out.println("\n NO HAY DATOS ");
				System.out.println(" |INGRESE CLIENTES PARA CONTINUAR| ");
			}
	}

	//BUSCAR CLIENTES//
	public void buscarCliente()
	{	
		conteo = 0;
		System.out.println("\n ESCRIBA EL CODIGO DEL CLIENTE ");
		System.out.print(" C-");
		codigo = oD.numero();
		for ( int i = 0; i < arregloCliente.size(); i++ )
		{
			if (codigo==arregloCliente.get(i).getCodigo())
			{
				System.out.println("\n-------------------------");
				System.out.println(" *CLIENTE ENCONTRADO* ");
				System.out.println("-------------------------");
				System.out.println(" ID : C-"+arregloCliente.get(i).getCodigo());
				System.out.println(" NOMBRE : "+ arregloCliente.get(i).getNombre());
				System.out.println(" APELLIDO : "+arregloCliente.get(i).getApellido());
				System.out.println(" NIT : "+arregloCliente.get(i).getNit());
				System.out.println("-------------------------");
				conteo++;
			}
		}

		if (conteo==0)
		{
			System.out.println("\n |BUSQUEDA SIN EXITO| *CLIENTE NO ENCONTRADO* ");
		}
			
	}

	//MODIFICAR CLIENTES//
	public void modificarCliente()
	{
		int i = arregloCliente.size();
		System.out.println("\n INGRESE EL CODIGO DEL CLIENTE ");
		System.out.print(" C-");
		codigo = oD.numero();
		if(i==0)
		{
			System.out.println("\n  NO HAY DATOS ");
			System.out.println(" |INGRESE CLIENTES PARA MODIFICAR|\n ");
		}
		else
		{	
			contador = 0;
			for (  i = 0; i < arregloCliente.size(); i++ )
			{
				if (codigo==arregloCliente.get(i).getCodigo())
				{
					do
					{
						conteo=0;	
						System.out.println("\n-------------------------");
						System.out.println(" *CLIENTE A MODIFICAR* ");
						System.out.println("-------------------------");
						System.out.println(" ID : C-"+arregloCliente.get(i).getCodigo());
						System.out.println(" NOMBRE : "+arregloCliente.get(i).getNombre());
						System.out.println(" APELLIDO : "+arregloCliente.get(i).getApellido());
						System.out.println(" NIT : "+arregloCliente.get(i).getNit());
						System.out.println("-------------------------\n");
						System.out.println(" |MENU DE MODIFICACIONES| ");
						System.out.println("  1 -> Modificar Nombre ");
						System.out.println("  2 -> Modificar Apellido ");
						System.out.println("  3 -> Modificar Nit \n");
						System.out.println(" Seleccione una Opcion ");
						System.out.print(" ");
						eleccionNumero = oD.numero();
						System.out.println("");
						switch(eleccionNumero)
						{
							case 1:
								System.out.println(" INGRESE EL NUEVO NOMBRE DEL CLIENTE ");
								System.out.print(" ");
								nombre = oD.texto();
								arregloCliente.get(i).setNombre(nombre);
								System.out.println("\n-------------------------");
								System.out.println(" *CLIENTE MODIFICADO* ");
								System.out.println("-------------------------");
								System.out.println(" ID : C-"+arregloCliente.get(i).getCodigo());
								System.out.println(" NOMBRE : "+arregloCliente.get(i).getNombre());
								System.out.println(" APELLIDO : "+arregloCliente.get(i).getApellido());
								System.out.println(" NIT : "+arregloCliente.get(i).getNit());
								System.out.println("-------------------------");
								break;

							case 2:
								System.out.println(" INGRESE EL NUEVO APELLIDO DEL CLIENTE ");
								System.out.print(" ");
								apellido = oD.texto();
								arregloCliente.get(i).setApellido(apellido);
								System.out.println("\n-------------------------");
								System.out.println(" *CLIENTE MODIFICADO* ");
								System.out.println("-------------------------");
								System.out.println(" ID : C-"+arregloCliente.get(i).getCodigo());
								System.out.println(" NOMBRE : "+arregloCliente.get(i).getNombre());
								System.out.println(" APELLIDO : "+arregloCliente.get(i).getApellido());
								System.out.println(" NIT : "+arregloCliente.get(i).getNit());
								System.out.println("-------------------------");
								break;

							case 3:
								System.out.println(" INGRESE EL NUEVO NIT PARA EL CLIENTE ");
								System.out.print(" ");
								nit = oD.texto();
								arregloCliente.get(i).setNit(nit);
								System.out.println("\n-------------------------");
								System.out.println(" *CLIENTE MODIFICADO* ");
								System.out.println("-------------------------");
								System.out.println(" ID : C-"+arregloCliente.get(i).getCodigo());
								System.out.println(" NOMBRE : "+arregloCliente.get(i).getNombre());
								System.out.println(" APELLIDO : "+arregloCliente.get(i).getApellido());
								System.out.println(" NIT : "+arregloCliente.get(i).getNit());
								System.out.println("-------------------------");
								break;

							default:
								System.out.println(" LA OPCION ELEGIDA NO ES VALIDA ");
								System.out.println(" VUELVA A INTENTARLO !  ");
								conteo=1;
								break;	
						}		
					}while(conteo==1);
					contador=1;			
					break;//ROMPE EL IF
				}	

			} if(contador==0)
			{
				System.out.println("\n |EL CODIGO INGRESADO NO EXISTE| ");
			}	
		}	
	}

	//ELIMINAR CLIENTES//
	public void eliminarCliente()
	{
		int i = arregloCliente.size();
		contador = 0;
		System.out.println("\n INGRESE EL CODIGO DEL CLIENTE ");
		System.out.print(" C-");
		codigo = oD.numero();
		if (i==0)
		{
			System.out.println("\n  NO HAY DATOS ");
			System.out.println(" |INGRESE CLIENTES PARA ELIMINAR| ");
		}
		else
		{
			conteo=0;
			for( i = 0; i < arregloCliente.size(); i++)
			{
				if(codigo==arregloCliente.get(i).getCodigo())
				{
					do
					{
						System.out.println("\n-------------------------");
						System.out.println(" *CLIENTE A ELIMINAR* ");
						System.out.println("-------------------------");
						System.out.println(" ID : C-"+arregloCliente.get(i).getCodigo());
						System.out.println(" NOMBRE : "+arregloCliente.get(i).getNombre());
						System.out.println(" APELLIDO : "+arregloCliente.get(i).getApellido());
						System.out.println(" NIT : "+arregloCliente.get(i).getNit());
						System.out.println("-------------------------\n");
						System.out.println(" Seguro que desea eliminar al CLIENTE...");
						System.out.println(" 1 -> ELIMINAR ");
						System.out.println(" 2 -> CONSERVAR ");
						System.out.print(" ");
						eleccionNumero = oD.numero();
						if(eleccionNumero == 1)
						{
							arregloCliente.remove(i);
							System.out.println("\n CLIENTE ELIMINADO CORRECTAMENTE ");
							reporteCliente();
						}
						else if(eleccionNumero == 2)
						{
							System.out.println("\n SE CONSERVO EL CLIENTE ");
							reporteCliente();
						}
						else
						{
							System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
							System.out.println(" VUELVA A INTENTARLO !  ");
						}
						conteo=1;
					}	while ((eleccionNumero != 1)&&(eleccionNumero != 2));	
					break;
				}
			}
			if (conteo==0)
			{
				System.out.println("\n |EL CODIGO INGRESADO NO EXISTE| ");
			}
		}
	}
}	
