
import java.util.ArrayList;
import java.math.RoundingMode;
public class ControladorFactura
{
	//VARIABLES//
	int conteoF; 	
	int factura = 22555;
	int codigoC;
	String nit;
	String apellido;
	String nombre;
	int codigoP1;
	String producto1;
	int cantidad1;
	double precio1;
	double iva1;
	int codigoP2;
	String producto2;
	int cantidad2;
	double precio2;
	double iva2;
	int codigoP3;
	String producto3;
	int cantidad3;
	double precio3;
	double iva3;
	double subtotal;
	double total;
	int contador;
	int conteo;
	double iva;
	int codigo;
	
	//VARIABLE PARA QUE EL USUARIO ELIJA//
	int eleccionNumero;
	
	//OBJETOS PARA FACTURAR//
	ObtenerDatos oD = new ObtenerDatos();
	ControladorCliente cC = new ControladorCliente();
	ControladorProducto cP = new ControladorProducto();

	//OBTENIENDO LOS DATOS DE LOS DEMAS ARRAY PARA FACTURAR//
	ArrayList <Cliente> arregloCliente = cC.getArrayCliente();
	ArrayList <Producto> arregloProducto = cP.getArrayProducto();
	static ArrayList <Factura> arregloFactura = new ArrayList <Factura>();

	//INGRESANDO LA FACTURA AL ARRAYLIST//
	public void facturacion(String nit, String nombre, String apellido,
							String producto1, int cantidad1, double precio1, double iva1,
							String producto2, int cantidad2, double precio2, double iva2,
							String producto3, int cantidad3, double precio3, double iva3,
		  					double subtotal, double total)
	{
		arregloFactura.add(new Factura(factura,nit,nombre,apellido,
									   producto1,cantidad1,precio1,iva1,
									   producto2,cantidad2,precio2,iva2,
									   producto3,cantidad3,precio3,iva3,
		  							   subtotal,total));
		imprimirFactura(factura,cantidad2,cantidad3);
		contador=0;
		factura++;
		while(contador==arregloFactura.size())
		{	
			factura++;
		}
		contador++;
	}


	//INGRESAR DATOS FACTURA SI EL CLIENTE NO POSEE CODIGO//
	public void formatoFacturacionSinCodigo()
	{
		contador = 0;
		System.out.println("\n [ NOTA IMPORTANTE : ]   ");
		System.out.println(" | CADA FACTURA TIENE UN MAXIMO DE 3 PRODUCTOS |  ");
		System.out.println("\n INGRESE EL NIT DEL CLIENTE ");
		System.out.print(" ");
		nit = oD.texto();
		System.out.println(" INGRESE EL NOMBRE DEL CLIENTE ");
		System.out.print(" ");
		nombre = oD.texto();
		System.out.println(" INGRESE EL APELLIDO DEL CLIENTE ");
		System.out.print(" ");
		apellido = oD.texto();
		System.out.println(" ESCRIBA EL CODIGO DEL PRODUCTO ");
		System.out.print(" P-");
		codigoP1 = oD.numero();
		cP.buscarProductoFactura(codigoP1);
		for ( int p1 = 0; p1 < arregloProducto.size(); p1++ )
		{
			if (codigoP1==arregloProducto.get(p1).getCodigo())
			{	
				System.out.println(" ESCRIBA LA CANTIDAD DE UNIDADES DEL PRODUCTO ");
				System.out.print(" ");
				cantidad1 = oD.numero();
				do
				{
					System.out.println("\n DESEA AGREGAR MAS PRODUCTOS ");
					System.out.println(" 1 -> Seguir Agregando ");
					System.out.println(" 2 -> Finalizar Compra ");
					System.out.print(" ");
					eleccionNumero = oD.numero();

					switch (eleccionNumero)
					{
						case 1:
						contador = 0;
						System.out.println("\n ESCRIBA EL CODIGO DEL PRODUCTO ");
						System.out.print(" P-");
						codigoP2 = oD.numero();
						cP.buscarProductoFactura(codigoP2);
						for( int p2 = 0; p2 < arregloProducto.size(); p2++ )
						{	
							if (codigoP2==arregloProducto.get(p2).getCodigo())
							{
								System.out.println(" ESCRIBA LA CANTIDAD DE UNIDADES DEL PRODUCTO ");
								System.out.print(" ");
								cantidad2 = oD.numero();
								do
								{
									System.out.println("\n DESEA AGREGAR MAS PRODUCTOS ");
									System.out.println(" 1 -> Seguir Agregando ");
									System.out.println(" 2 -> Finalizar Compra ");
									System.out.print(" ");
									eleccionNumero = oD.numero();
									switch (eleccionNumero)
									{
										case 1:
										contador=0;
										System.out.println("\n ESCRIBA EL CODIGO DEL PRODUCTO ");
										System.out.print(" P-");
										codigoP3 = oD.numero();
										cP.buscarProductoFactura(codigoP3);
										for( int p3 = 0; p3 < arregloProducto.size(); p3++ )
										{
											if(codigoP3 == arregloProducto.get(p3).getCodigo())
											{
												System.out.println(" ESCRIBA LA CANTIDAD DE UNIDADES DEL PRODUCTO ");
												System.out.print(" ");
												cantidad3 = oD.numero();
												producto1 = arregloProducto.get(p1).getProducto()+" "+
															arregloProducto.get(p1).getDescripcion();
												precio1 = arregloProducto.get(p1).getPrecio();
												iva1 = (arregloProducto.get(p1).getIva()*cantidad1);
												producto2 = arregloProducto.get(p2).getProducto()+" "+
															arregloProducto.get(p2).getDescripcion();
												precio2 = arregloProducto.get(p2).getPrecio();
												iva2 = (arregloProducto.get(p2).getIva()*cantidad2);
												producto3 = arregloProducto.get(p3).getProducto()+" "+
															arregloProducto.get(p3).getDescripcion();
												precio3 = arregloProducto.get(p3).getPrecio();
												iva3 = (arregloProducto.get(p3).getIva()*cantidad3);
												subtotal = (cantidad1 * precio1)+(cantidad2*precio2)+(cantidad3*precio3);
												total = subtotal + iva1 + iva2 + iva3;
												facturacion(nit,nombre,apellido,
								  							producto1,cantidad1,precio1,iva1,
								   							producto2,cantidad2,precio2,iva2,
								   							producto3,cantidad3,precio3,iva3,
	  							  							subtotal,total);
												contador++;
												break;
											}	
										}	
										if (contador==0)
										{
											System.out.println("\n |NO SE PUEDE FACTURAR| *PRODUCTO NO ENCONTRADO* ");;
										}
										break;//case1

										case 2:
										producto1 = arregloProducto.get(p1).getProducto()+" "+
													arregloProducto.get(p1).getDescripcion();
										precio1 = arregloProducto.get(p1).getPrecio();
										iva1 = (arregloProducto.get(p1).getIva()*cantidad1);
										producto2 = arregloProducto.get(p2).getProducto()+" "+
													arregloProducto.get(p2).getDescripcion();
										precio2 = arregloProducto.get(p2).getPrecio();
										iva2 = (arregloProducto.get(p2).getIva()*cantidad2);
										subtotal = (cantidad1 * precio1)+(cantidad2 * precio2);
										total = subtotal + iva1 + iva2;
										facturacion(nit,nombre,apellido,
												    producto1,cantidad1,precio1,iva1,
									  			    producto2,cantidad2,precio2,iva2,
									  			    null,0,0,0,
									  				subtotal,total);
										break;//case2	

										default:
										System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
										System.out.println(" VUELVA A INTENTARLO ! ");	
										break;//default
									}
												
								}	while((eleccionNumero!=1)&&(eleccionNumero!=2));
									contador++;
									break;
							}		
						}
						if (contador==0)
						{
							System.out.println("\n |NO SE PUEDE FACTURAR| *PRODUCTO NO ENCONTRADO* ");;
						}	
						break; //CASE1

						case 2:
						producto1 = arregloProducto.get(p1).getProducto()+" "+
									arregloProducto.get(p1).getDescripcion();
						precio1 = arregloProducto.get(p1).getPrecio();
						iva1 = (arregloProducto.get(p1).getIva()*cantidad1);
						subtotal = cantidad1 * precio1;
						total = subtotal + iva1;
						facturacion(nit,nombre,apellido,
									producto1,cantidad1,precio1,iva1,
									null,0,0,0,
									null,0,0,0,
							     	subtotal,total);
						break;//CASE2

						default:
						System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
						System.out.println(" VUELVA A INTENTARLO ! ");	
						break;//default
					}
				}	while((eleccionNumero!=1)&&(eleccionNumero!=2));
			
				contador++;
				break;	
			}
		}
		if (contador==0)
		{
			System.out.println("\n |NO SE PUEDE FACTURAR| *PRODUCTO NO ENCONTRADO* ");;
		}
	}

//INGRESAR DATOS FACTURA SI EL CLIENTE POSEE CODIGO//
	public void formatoFacturacionConCodigo()
	{
		contador = 0;
		conteo =0;
		System.out.println("\n [ NOTA IMPORTANTE : ]   ");
		System.out.println(" | CADA FACTURA TIENE UN MAXIMO DE 3 PRODUCTOS |  ");
		System.out.println("\n INGRESE EL CODIGO DEL CLIENTE ");
		System.out.print(" C-");
		codigoC = oD.numero();
		for ( int c = 0; c < arregloCliente.size(); c++ )
		{
			if (codigoC==arregloCliente.get(c).getCodigo())
			{
				conteo++;
				nit = arregloCliente.get(c).getNit();
				nombre = arregloCliente.get(c).getNombre();
				apellido = arregloCliente.get(c).getApellido();
				System.out.println(" ESCRIBA EL CODIGO DEL PRODUCTO ");
				System.out.print(" P-");
				codigoP1 = oD.numero();
				cP.buscarProductoFactura(codigoP1);
				for ( int p1 = 0; p1 < arregloProducto.size(); p1++ )
				{
					if (codigoP1==arregloProducto.get(p1).getCodigo())
					{	
						System.out.println(" ESCRIBA LA CANTIDAD DE UNIDADES DEL PRODUCTO ");
						System.out.print(" ");
						cantidad1 = oD.numero();
						do
						{
							System.out.println("\n DESEA AGREGAR MAS PRODUCTOS ");
							System.out.println(" 1 -> Seguir Agregando ");
							System.out.println(" 2 -> Finalizar Compra ");
							System.out.print(" ");
							eleccionNumero = oD.numero();

							switch (eleccionNumero)
							{
								case 1:
								contador = 0;
								System.out.println("\n ESCRIBA EL CODIGO DEL PRODUCTO ");
								System.out.print(" P-");
								codigoP2 = oD.numero();
								cP.buscarProductoFactura(codigoP2);
								for( int p2 = 0; p2 < arregloProducto.size(); p2++ )
								{	
									if (codigoP2==arregloProducto.get(p2).getCodigo())
									{
										System.out.println(" ESCRIBA LA CANTIDAD DE UNIDADES DEL PRODUCTO ");
										System.out.print(" ");
										cantidad2 = oD.numero();
										do
										{
											System.out.println("\n DESEA AGREGAR MAS PRODUCTOS ");
											System.out.println(" 1 -> Seguir Agregando ");
											System.out.println(" 2 -> Finalizar Compra ");
											System.out.print(" ");
											eleccionNumero = oD.numero();
									
											switch (eleccionNumero)
											{
												case 1:
												contador=0;
												System.out.println("\n ESCRIBA EL CODIGO DEL PRODUCTO ");
												System.out.print(" P-");
												codigoP3 = oD.numero();
												cP.buscarProductoFactura(codigoP3);
												for( int p3 = 0; p3 < arregloProducto.size(); p3++ )
												{
													if(codigoP3 == arregloProducto.get(p3).getCodigo())
													{
														System.out.println(" ESCRIBA LA CANTIDAD DE UNIDADES DEL PRODUCTO ");
														System.out.print(" ");
														cantidad3 = oD.numero();
														producto1 = arregloProducto.get(p1).getProducto()+" "+
																	arregloProducto.get(p1).getDescripcion();
														precio1 = arregloProducto.get(p1).getPrecio();
														iva1 = (arregloProducto.get(p1).getIva()*cantidad1);
														producto2 = arregloProducto.get(p2).getProducto()+" "+
																	arregloProducto.get(p2).getDescripcion();
														precio2 = arregloProducto.get(p2).getPrecio();
														iva2 = (arregloProducto.get(p2).getIva()*cantidad2);
														producto3 = arregloProducto.get(p3).getProducto()+" "+
																	arregloProducto.get(p3).getDescripcion();
														precio3 = arregloProducto.get(p3).getPrecio();
														iva3 = (arregloProducto.get(p3).getIva()*cantidad3);
														subtotal = (cantidad1 * precio1)+(cantidad2*precio2)+(cantidad3*precio3);
														total = subtotal + iva1 + iva2 + iva3;
														facturacion(nit,nombre,apellido,
										  							producto1,cantidad1,precio1,iva1,
										   							producto2,cantidad2,precio2,iva2,
										   							producto3,cantidad3,precio3,iva3,
			  							  							subtotal,total);
														contador++;
														break;
													}	
												}	
												if (contador==0)
												{
													System.out.println("\n |NO SE PUEDE FACTURAR| *PRODUCTO NO ENCONTRADO* ");;
												}
												break;//case1

												case 2:
												producto1 = arregloProducto.get(p1).getProducto()+" "+
															arregloProducto.get(p1).getDescripcion();
												precio1 = arregloProducto.get(p1).getPrecio();
												iva1 = (arregloProducto.get(p1).getIva()*cantidad1);
												producto2 = arregloProducto.get(p2).getProducto()+" "+
															arregloProducto.get(p2).getDescripcion();
												precio2 = arregloProducto.get(p2).getPrecio();
												iva2 = (arregloProducto.get(p2).getIva()*cantidad2);
												subtotal = (cantidad1 * precio1)+(cantidad2 * precio2);
												total = subtotal + iva1 + iva2;
												facturacion(nit,nombre,apellido,
												  			producto1,cantidad1,precio1,iva1,
									  			    		producto2,cantidad2,precio2,iva2,
									  			    		null,0,0,0,
									  						subtotal,total);
												break;//case2	

												default:
												System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
												System.out.println(" VUELVA A INTENTARLO ! ");	
												break;//default
											}
												
										}	while((eleccionNumero!=1)&&(eleccionNumero!=2));
											contador++;
											break;
									}		
								}
								if (contador==0)
								{
									System.out.println("\n |NO SE PUEDE FACTURAR| *PRODUCTO NO ENCONTRADO* ");;
								}	
								break; //CASE1

								case 2:
								producto1 = arregloProducto.get(p1).getProducto()+" "+
											arregloProducto.get(p1).getDescripcion();
								precio1 = arregloProducto.get(p1).getPrecio();
								iva1 = (arregloProducto.get(p1).getIva()*cantidad1);
								subtotal = cantidad1 * precio1;
								total = subtotal + iva1;
								facturacion(nit,nombre,apellido,
											producto1,cantidad1,precio1,iva1,
											null,0,0,0,
											null,0,0,0,
									     	subtotal,total);
								break;//CASE2

								default:
								System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
								System.out.println(" VUELVA A INTENTARLO ! ");	
								break;//default
							}
						}	while((eleccionNumero!=1)&&(eleccionNumero!=2));
							contador++;
							break;	
					}
				}
				if (contador==0)
				{
					System.out.println("\n |NO SE PUEDE FACTURAR| *PRODUCTO NO ENCONTRADO* ");;
				}
			}
		}

		if (conteo==0)
		{
			System.out.println("\n |NO SE PUEDE FACTURAR| *EL CODIGO DEL CLIENTE NO EXISTE* ");
		}
		
	}


	//IMPRIMIR FACTURA//
	public void imprimirFactura(int codigo, int cantidad2,int cantidad3)
	{			
		conteo = 0;
		for ( int i = 0; i < arregloFactura.size(); i++ )
		{
			if (codigo == arregloFactura.get(i).getCodigoFactura())
			{
				System.out.println("\n          F A C T U R A         ");
				System.out.println("----------------------------------");
				System.out.println(" FACTURA No. "+arregloFactura.get(i).getCodigoFactura());
				System.out.println("----------------------------------");
				System.out.println(" CODIGO FACTURA : F-"+arregloFactura.get(i).getCodigoFactura());
				System.out.println(" NIT : "+arregloFactura.get(i).getNitCliente());
				System.out.println(" Nombre Cliente : "+arregloFactura.get(i).getNombreCliente());
				System.out.println(" Apellido Cliente : "+arregloFactura.get(i).getApellidoCliente());
				System.out.println("----------------------------------");
				System.out.println(" Producto 1 : "+arregloFactura.get(i).getProductoUno());
				System.out.println(" Precio : Q."+arregloFactura.get(i).getPrecioUno());
				System.out.println(" Cantidad : "+arregloFactura.get(i).getCantidadUno()+" unidades ");
				System.out.println(" IVA : Q."+ (double)Math.round(arregloFactura.get(i).getIvaUno()*100d)/100);
				if((cantidad2!=0)&&(cantidad3==0))
				{
					System.out.println("----------------------------------");
					System.out.println(" Producto 2 : "+arregloFactura.get(i).getProductoDos());
					System.out.println(" Precio : Q."+arregloFactura.get(i).getPrecioDos());
					System.out.println(" Cantidad : "+arregloFactura.get(i).getCantidadDos()+" unidades ");
					System.out.println(" IVA : Q."+ (double)Math.round(arregloFactura.get(i).getIvaDos()*100d)/100);
				}
				if((cantidad2!=0)&&(cantidad3!=0))
				{
					System.out.println("----------------------------------");
					System.out.println(" Producto 2 : "+arregloFactura.get(i).getProductoDos());
					System.out.println(" Precio : Q."+arregloFactura.get(i).getPrecioDos());
					System.out.println(" Cantidad : "+arregloFactura.get(i).getCantidadDos()+" unidades ");
					System.out.println(" IVA : Q."+ (double)Math.round(arregloFactura.get(i).getIvaDos()*100d)/100);
					System.out.println("----------------------------------");
					System.out.println(" Producto 3 : "+arregloFactura.get(i).getProductoTres());
					System.out.println(" Precio : Q."+arregloFactura.get(i).getPrecioTres());
					System.out.println(" Cantidad : "+arregloFactura.get(i).getCantidadTres()+" unidades ");
					System.out.println(" IVA : Q."+ (double)Math.round(arregloFactura.get(i).getIvaTres()*100d)/100);
				}
				iva = arregloFactura.get(i).getIvaUno()+arregloFactura.get(i).getIvaDos()+arregloFactura.get(i).getIvaTres();
				System.out.println("----------------------------------");
				System.out.println(" SUBTOTAL :          Q."+ (double)Math.round(arregloFactura.get(i)
									.getSubTotalCompra()*100d)/100);
				System.out.println(" TOTAL IVA :         Q."+ (double)Math.round(iva*100d)/100);
				System.out.println("__________________________________");
				System.out.println("\n TOTAL COMPRA :      Q."+ (double)Math.round(arregloFactura.get(i)
									.getTotalCompra()*100d)/100);
				System.out.println("----------------------------------");
				conteo++;
			}
		}

	}

	//BUSCAR FACTURAS//
	public void buscarFactura()
	{			
		conteo = 0;
		System.out.println("\n ESCRIBA EL CODIGO DE LA FACTURA ");
		System.out.print(" F-");
		codigo = oD.numero();
		for ( int i = 0; i < arregloFactura.size(); i++ )
		{
			if (codigo == arregloFactura.get(i).getCodigoFactura())
			{
				System.out.println("\n--------------------------------");
				System.out.println(" *FACTURA ENCONTRADA* ");
				System.out.println("----------------------------------");
				System.out.println(" FACTURA No. "+arregloFactura.get(i).getCodigoFactura());
				System.out.println("----------------------------------");
				System.out.println(" CODIGO FACTURA : F-"+arregloFactura.get(i).getCodigoFactura());
				System.out.println(" NIT : "+arregloFactura.get(i).getNitCliente());
				System.out.println(" Nombre Cliente : "+arregloFactura.get(i).getNombreCliente());
				System.out.println(" Apellido Cliente : "+arregloFactura.get(i).getApellidoCliente());
				System.out.println("----------------------------------");
				System.out.println(" Producto 1 : "+arregloFactura.get(i).getProductoUno());
				System.out.println(" Precio : Q."+arregloFactura.get(i).getPrecioUno());
				System.out.println(" Cantidad : "+arregloFactura.get(i).getCantidadUno()+" unidades ");
				System.out.println(" IVA : Q."+ (double)Math.round(arregloFactura.get(i).getIvaUno()*100d)/100);

				if((arregloFactura.get(i).getCantidadDos()!=0)&&(arregloFactura.get(i).getCantidadTres()==0))
				{
					System.out.println("----------------------------------");
					System.out.println(" Producto 2 : "+arregloFactura.get(i).getProductoDos());
					System.out.println(" Precio : Q."+arregloFactura.get(i).getPrecioDos());
					System.out.println(" Cantidad : "+arregloFactura.get(i).getCantidadDos()+" unidades ");
					System.out.println(" IVA : Q."+ (double)Math.round(arregloFactura.get(i).getIvaDos()*100d)/100);
				}
				else if((arregloFactura.get(i).getCantidadDos()!=0)&&(arregloFactura.get(i).getCantidadTres()!=0))
				{
					System.out.println("----------------------------------");
					System.out.println(" Producto 2 : "+arregloFactura.get(i).getProductoDos());
					System.out.println(" Precio : Q."+arregloFactura.get(i).getPrecioDos());
					System.out.println(" Cantidad : "+arregloFactura.get(i).getCantidadDos()+" unidades ");
					System.out.println(" IVA : Q."+ (double)Math.round(arregloFactura.get(i).getIvaDos()*100d)/100);
					System.out.println("----------------------------------");
					System.out.println(" Producto 3 : "+arregloFactura.get(i).getProductoTres());
					System.out.println(" Precio : Q."+arregloFactura.get(i).getPrecioTres());
					System.out.println(" Cantidad : "+arregloFactura.get(i).getCantidadTres()+" unidades ");
					System.out.println(" IVA : Q."+ (double)Math.round(arregloFactura.get(i).getIvaTres()*100d)/100);
				}
				iva = arregloFactura.get(i).getIvaUno()+arregloFactura.get(i).getIvaDos()+arregloFactura.get(i).getIvaTres();
				System.out.println("----------------------------------");
				System.out.println(" SUBTOTAL :          Q."+ (double)Math.round(arregloFactura.get(i).getSubTotalCompra()*100d)/100);
				System.out.println(" TOTAL IVA :         Q."+ (double)Math.round(iva*100d)/100);
				System.out.println("__________________________________");
				System.out.println("\n TOTAL COMPRA :      Q."+ (double)Math.round(arregloFactura.get(i).getTotalCompra()*100d)/100);
				System.out.println("----------------------------------");
				conteo++;
			}
		}

		if (conteo==0)
		{
			System.out.println("\n |BUSQUEDA SIN EXITO| *FACTURA NO ENCONTRADA* ");
		}
	}

	//ELIMINAR FACTURAS//
	public void eliminarFactura()
	{
		int i = arregloFactura.size();
		conteo = 0;
		System.out.println("\n INGRESE EL CODIGO DE LA FACTURA ");
		System.out.print(" F-");
		codigo = oD.numero();
		if (i==0)
		{
			System.out.println("\n NO HAY DATOS ");
			System.out.println(" |FACTURE PARA ELIMINAR| ");
		}else
		{
			conteo =0;
			for( i = 0; i < arregloFactura.size(); i++)
			{
				if(codigo==arregloFactura.get(i).getCodigoFactura())
				{
					do
					{	
						System.out.println("\n--------------------------------------");
						System.out.println(" *FACTURA A ELIMINAR* ");
						System.out.println("--------------------------------------");
						System.out.println(" FACTURA No. "+arregloFactura.get(i).getCodigoFactura());
						System.out.println("----------------------------------");
						System.out.println(" CODIGO FACTURA : F-"+arregloFactura.get(i).getCodigoFactura());
						System.out.println(" NIT : "+arregloFactura.get(i).getNitCliente());
						System.out.println(" Nombre Cliente : "+arregloFactura.get(i).getNombreCliente());
						System.out.println(" Apellido Cliente : "+arregloFactura.get(i).getApellidoCliente());
						System.out.println("----------------------------------");
						System.out.println(" Producto 1 : "+arregloFactura.get(i).getProductoUno());
						System.out.println(" Precio : Q."+arregloFactura.get(i).getPrecioUno());
						System.out.println(" Cantidad : "+arregloFactura.get(i).getCantidadUno()+" unidades ");
						System.out.println(" IVA : Q."+ (double)Math.round(arregloFactura.get(i).getIvaUno()*100d)/100);
						if((arregloFactura.get(i).getCantidadDos()!=0)&&(arregloFactura.get(i).getCantidadTres()==0))
						{
							System.out.println("----------------------------------");
							System.out.println(" Producto 2 : "+arregloFactura.get(i).getProductoDos());
							System.out.println(" Precio : Q."+arregloFactura.get(i).getPrecioDos());
							System.out.println(" Cantidad : "+arregloFactura.get(i).getCantidadDos()+" unidades ");
							System.out.println(" IVA : Q."+ (double)Math.round(arregloFactura.get(i).getIvaDos()*100d)/100);
						}
						else if((arregloFactura.get(i).getCantidadDos()!=0)&&(arregloFactura.get(i).getCantidadTres()!=0))
						{
							System.out.println("----------------------------------");
							System.out.println(" Producto 2 : "+arregloFactura.get(i).getProductoDos());
							System.out.println(" Precio : Q."+arregloFactura.get(i).getPrecioDos());
							System.out.println(" Cantidad : "+arregloFactura.get(i).getCantidadDos()+" unidades ");
							System.out.println(" IVA : Q."+ (double)Math.round(arregloFactura.get(i).getIvaDos()*100d)/100);
							System.out.println("----------------------------------");
							System.out.println(" Producto 3 : "+arregloFactura.get(i).getProductoTres());
							System.out.println(" Precio : Q."+arregloFactura.get(i).getPrecioTres());
							System.out.println(" Cantidad : "+arregloFactura.get(i).getCantidadTres()+" unidades ");
							System.out.println(" IVA : Q."+ (double)Math.round(arregloFactura.get(i).getIvaTres()*100d)/100);
						}
							iva = arregloFactura.get(i).getIvaUno()+arregloFactura.get(i).getIvaDos()+arregloFactura.get(i).getIvaTres();
							System.out.println("----------------------------------");
							System.out.println(" SUBTOTAL :          Q."+ (double)Math.round(arregloFactura.get(i).getSubTotalCompra()*100d)/100);
							System.out.println(" TOTAL IVA :         Q."+ (double)Math.round(iva*100d)/100);
							System.out.println("__________________________________");
							System.out.println("\n TOTAL COMPRA :    Q."+ (double)Math.round(arregloFactura.get(i).getTotalCompra()*100d)/100);
						System.out.println("----------------------------------\n");
						System.out.println(" Seguro que desea eliminar la FACTURA...");
						System.out.println(" 1 -> ELIMINAR ");
						System.out.println(" 2 -> CONSERVAR ");
						System.out.print(" ");
						eleccionNumero=oD.numero();
						if(eleccionNumero==1)
						{
							arregloFactura.remove(i);
							System.out.println("\n FACTURA ELIMINADA CORRECTAMENTE ");
						}
						else if(eleccionNumero==2)
						{
							System.out.println("\n SE CONSERVO LA FACTURA ");
							reporteFactura();
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

	//REPORTE FACTURAS//
	public void reporteFactura()
	{
		int i = arregloFactura.size();
		conteo = 0;
		if (i>0)
		{	
			System.out.println("\n--------------------------------------");
			System.out.println(" *FACTURAS REALIZADAS* ");
			for (i = 0; i<arregloFactura.size(); i++)
			{
				System.out.println("--------------------------------------");
				System.out.println(" FACTURA No. "+arregloFactura.get(i).getCodigoFactura());
				System.out.println("----------------------------------");
				System.out.println(" CODIGO FACTURA : F-"+arregloFactura.get(i).getCodigoFactura());
				System.out.println(" NIT : "+arregloFactura.get(i).getNitCliente());
				System.out.println(" Nombre Cliente : "+arregloFactura.get(i).getNombreCliente());
				System.out.println(" Apellido Cliente : "+arregloFactura.get(i).getApellidoCliente());
				System.out.println("----------------------------------");
				System.out.println(" Producto 1 : "+arregloFactura.get(i).getProductoUno());
				System.out.println(" Precio : Q."+arregloFactura.get(i).getPrecioUno());
				System.out.println(" Cantidad : "+arregloFactura.get(i).getCantidadUno()+" unidades ");
				System.out.println(" IVA : Q."+ (double)Math.round(arregloFactura.get(i).getIvaUno()*100d)/100);
				if((arregloFactura.get(i).getCantidadDos()!=0)&&(arregloFactura.get(i).getCantidadTres()==0))
				{
					System.out.println("----------------------------------");
					System.out.println(" Producto 2 : "+arregloFactura.get(i).getProductoDos());
					System.out.println(" Precio : Q."+arregloFactura.get(i).getPrecioDos());
					System.out.println(" Cantidad : "+arregloFactura.get(i).getCantidadDos()+" unidades ");
					System.out.println(" IVA : Q."+ (double)Math.round(arregloFactura.get(i).getIvaDos()*100d)/100);
				}
				else if((arregloFactura.get(i).getCantidadDos()!=0)&&(arregloFactura.get(i).getCantidadTres()!=0))
				{
					System.out.println("----------------------------------");
					System.out.println(" Producto 2 : "+arregloFactura.get(i).getProductoDos());
					System.out.println(" Precio : Q."+arregloFactura.get(i).getPrecioDos());
					System.out.println(" Cantidad : "+arregloFactura.get(i).getCantidadDos()+" unidades ");
					System.out.println(" IVA : Q."+ (double)Math.round(arregloFactura.get(i).getIvaDos()*100d)/100);
					System.out.println("----------------------------------");
					System.out.println(" Producto 3 : "+arregloFactura.get(i).getProductoTres());
					System.out.println(" Precio : Q."+arregloFactura.get(i).getPrecioTres());
					System.out.println(" Cantidad : "+arregloFactura.get(i).getCantidadTres()+" unidades ");
					System.out.println(" IVA : Q."+ (double)Math.round(arregloFactura.get(i).getIvaTres()*100d)/100);
				}
				iva = arregloFactura.get(i).getIvaUno()+arregloFactura.get(i).getIvaDos()+arregloFactura.get(i).getIvaTres();
				System.out.println("----------------------------------");
				System.out.println(" SUBTOTAL :          Q."+ (double)Math.round(arregloFactura.get(i).getSubTotalCompra()*100d)/100);
				System.out.println(" TOTAL IVA :         Q."+ (double)Math.round(iva*100d)/100);
				System.out.println("__________________________________");
				System.out.println("\n TOTAL COMPRA :      Q."+ (double)Math.round(arregloFactura.get(i).getTotalCompra()*100d)/100);
				System.out.println("----------------------------------\n\n");
				conteo++;
			}
		}
		 else if (conteo==0)
			{
				System.out.println("\n NO HAY DATOS ");
				System.out.println(" |FACTURE PARA CONTINUAR|\n ");
			}
	}
}	
