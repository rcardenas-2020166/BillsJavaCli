
public class Vista
{

 	//ESTA VARIABLE ME RETORNA//
 	int conteo;
 	int retornar;
 	int facturar;
 	//VARABLE CON LA QUE EL USUARIO DECIDE//
 	int eleccion;

 	//OBJETO ELEGIR OPCIONES//
	ObtenerDatos oD = new ObtenerDatos();
	
	//OBJETOS//
	ControladorFactura cF = new ControladorFactura();
	ControladorProducto cP = new ControladorProducto();
	ControladorCliente cC = new ControladorCliente();

	public void vistaOpciones()
	{
		retornar = 0;	

	do{
		System.out.println("\n |MENU DE OPCIONES| ");
		System.out.println("  1 -> Clientes ");
		System.out.println("  2 -> Productos ");
		System.out.println("  3 -> Facturacion ");
		System.out.println("  4 -> SALIR \n");
		System.out.println(" Seleccione una Opcion ");
		System.out.print(" ");
		eleccion = oD.numero();
		switch (eleccion)
		{
			case 1:
				conteo=0;
				do
				{
					System.out.println("\n -CIENTES- \n");
					System.out.println(" |MENU DE OPCIONES| ");
					System.out.println("  1 -> Ingresar Cientes ");
					System.out.println("  2 -> Buscar Clientes");
					System.out.println("  3 -> Modificar Clientes ");
					System.out.println("  4 -> Eliminar Clientes ");
					System.out.println("  5 -> Reporte de Cientes" );
					System.out.println("  6 -> REGRESAR AL MENU \n");
					System.out.println(" Seleccione una Opcion ");
					System.out.print(" ");
					eleccion = oD.numero();
					switch(eleccion)
					{
						case 1:
							retornar++;
							System.out.println("\n *INGRESAR* ");
							do
							{
								cC.ingresarCliente();
								do
								{
									System.out.println("\n DESEA AGREGAR MAS CLIENTES ");
									System.out.println(" 1 -> SEGUIR AGREGANDO" );
									System.out.println(" 2 -> REGRESAR AL SUBMENU" );
									System.out.print(" ");
									eleccion = oD.numero();
									conteo++;
									if(((eleccion!=1))&&((eleccion!=2)))
									{
										System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
										System.out.println(" VUELVA A INTENTARLO ! ");
									}
								}	while((eleccion!=1)&&(eleccion!=2));
									if(eleccion == 2)
									{		
									conteo=0;
									}
							}	while(eleccion==1);
							break;//INGRESAR

						case 2:
							retornar++;
							System.out.println("\n *BUSCAR* ");
							do
							{
								cC.buscarCliente();
								do
								{
									System.out.println("\n DESEA BUSCAR MAS CLIENTES ");
									System.out.println(" 1 -> SEGUIR BUSCANDO" );
									System.out.println(" 2 -> REGRESAR AL SUBMENU" );
									System.out.print(" ");
									eleccion = oD.numero();
									conteo++;
									if(((eleccion!=1))&&((eleccion!=2)))
									{
										System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
										System.out.println(" VUELVA A INTENTARLO ! ");
									}
								}	while((eleccion!=1)&&(eleccion!=2));		
								if(eleccion == 2)
								{		
								conteo=0;
								}
							}	while(eleccion==1);	
							break;//BUSCAR

						case 3:
							retornar++;
							System.out.println("\n *MODIFICAR* ");
							do
							{	
								cC.modificarCliente();
								do
								{	
									System.out.println("\n DESEA MODIFICAR MAS CLIENTES ");
									System.out.println(" 1 -> SEGUIR MODIFICANDO" );
									System.out.println(" 2 -> REGRESAR AL SUBMENU" );
									System.out.print(" ");
									eleccion = oD.numero();
									conteo++;	
									if(((eleccion!=1))&&((eleccion!=2)))
									{
										System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
										System.out.println(" VUELVA A INTENTARLO ! ");
									}
								}	while((eleccion!=1)&&(eleccion!=2));
								if(eleccion == 2)
								{		
									conteo=0;
								}
							}	while(eleccion==1);
							break;//MODIFICAR

						case 4:
							retornar++;
							System.out.println("\n *ELIMINAR* ");
							do
							{	
								cC.eliminarCliente();
								do
								{
									System.out.println("\n DESEA ELIMINAR MAS CLIENTES ");
									System.out.println(" 1 -> SEGUIR ELIMINANDO" );
									System.out.println(" 2 -> REGRESAR AL SUBMENU" );
									System.out.print(" ");
									eleccion = oD.numero();
									conteo++;
									if(((eleccion!=1))&&((eleccion!=2)))
									{
										System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
										System.out.println(" VUELVA A INTENTARLO ! ");
									}
								}	while((eleccion!=1)&&(eleccion!=2));	
								if(eleccion == 2)
								{		
									conteo=0;
								}
							}	while(eleccion==1);
							break;//ELIMINAR

						case 5:
							retornar++;
							System.out.println("\n *REPORTE DE CLIENTES* ");
							cC.reporteCliente();
							do
							{
								System.out.println("\n |OPCIONES| ");
								System.out.println(" 1 -> REGRESAR AL SUBMENU" );
								System.out.println(" 2 -> SALIR DEL PROGRAMA" );
								System.out.println("\n Seleccione una Opcion ");
								System.out.print(" ");
								eleccion = oD.numero();
								if(eleccion==1)
								{
									conteo = 0;
								}
								else if (eleccion==2)
								{
									conteo++;
									System.out.println("\n NOS VEMOS ! VUELVA PRONTO ");
								}
								else
								{
									System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
									System.out.println(" VUELVA A INTENTARLO ! ");
								}
							}	while((eleccion!=1)&&(eleccion!=2));
							break;//REPORTE	

						case 6:
							conteo++;
							retornar = 0;
							break;//REGRESAR

						default:
							System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
							System.out.println(" VUELVA A INTENTARLO ! ");
							conteo=0;
							retornar++;
							break;//default	
					}
						}while(conteo==0);
				break;//CLIENTES		

			case 2:
				conteo=0;
				do
				{
					System.out.println("\n -PRODUCTOS- \n");
					System.out.println(" |MENU DE OPCIONES| ");
					System.out.println("  1 -> Ingresar Productos ");
					System.out.println("  2 -> Buscar Productos");
					System.out.println("  3 -> Modificar Productos ");
					System.out.println("  4 -> Eliminar Productos ");
					System.out.println("  5 -> Reporte de Productos" );
					System.out.println("  6 -> REGRESAR AL MENU \n");
					System.out.println(" Seleccione una Opcion ");
					System.out.print(" ");
					eleccion = oD.numero();
					switch(eleccion)
					{
						case 1:
							retornar++;
							System.out.println("\n *INGRESAR* ");
							do
							{
								cP.ingresarProducto();
								do
								{
									System.out.println("\n DESEA AGREGAR MAS PRODUCTOS ");
									System.out.println(" 1 -> SEGUIR AGREGANDO" );
									System.out.println(" 2 -> REGRESAR AL SUBMENU" );
									System.out.print(" ");
									eleccion = oD.numero();
									conteo++;	
									if(((eleccion!=1))&&((eleccion!=2)))
									{
										System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
										System.out.println(" VUELVA A INTENTARLO ! ");
									}
								}	while((eleccion!=1)&&(eleccion!=2));	
								if(eleccion == 2)
								{		
									conteo=0;
								}
							}	while(eleccion==1);
							break;//INGRESAR

						case 2:
							retornar++;
							System.out.println("\n *BUSCAR* ");
							do
							{
								cP.buscarProducto();
								do
								{
									System.out.println("\n DESEA BUSCAR MAS PRODUCTOS ");
									System.out.println(" 1 -> SEGUIR BUSCANDO" );
									System.out.println(" 2 -> REGRESAR AL SUBMENU" );
									System.out.print(" ");
									eleccion = oD.numero();
									conteo++;
									if(((eleccion!=1))&&((eleccion!=2)))
									{
										System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
										System.out.println(" VUELVA A INTENTARLO ! ");
									}
								}	while((eleccion!=1)&&(eleccion!=2));	
								if(eleccion == 2)
								{		
								conteo=0;
								}
							}	while(eleccion==1);
							break;//BUSCAR

						case 3:
							retornar++;
							System.out.println("\n *MODIFICAR* ");
							do
							{
								cP.modificarProducto();
								do
								{
									System.out.println("\n DESEA MODIFICAR MAS PRODUCTOS ");
									System.out.println(" 1 -> SEGUIR MODIFICANDO" );
									System.out.println(" 2 -> REGRESAR AL SUBMENU" );
									System.out.print(" ");
									eleccion = oD.numero();
									conteo++;
									if(((eleccion!=1))&&((eleccion!=2)))
									{
										System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
										System.out.println(" VUELVA A INTENTARLO ! ");
									}	
								}	while((eleccion!=1)&&(eleccion!=2));
								if(eleccion == 2)
								{		
									conteo=0;
								}
							}	while(eleccion==1);
						break;//MODIFICAR

						case 4:
							retornar++;
							System.out.println("\n *ELIMINAR* ");
							do
							{	
								cP.eliminarProducto();
								do
								{
									System.out.println("\n DESEA ELIMINAR MAS PRODUCTOS ");
									System.out.println(" 1 -> SEGUIR ELIMINANDO" );
									System.out.println(" 2 -> REGRESAR AL SUBMENU" );
									System.out.print(" ");
									eleccion = oD.numero();
									conteo++;
									if(((eleccion!=1))&&((eleccion!=2)))
									{
										System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
										System.out.println(" VUELVA A INTENTARLO ! ");
									}	
								}	while((eleccion!=1)&&(eleccion!=2));	
							
								if(eleccion == 2)
								{		
									conteo=0;
								}
							}	while(eleccion==1);
							break;//ELIMINAR

						case 5:
							retornar++;
							System.out.println("\n *REPORTE DE PRODUCTOS* ");
							cP.reporteProducto();
							do
							{
								System.out.println("\n |OPCIONES| ");
								System.out.println(" 1 -> REGRESAR AL SUBMENU" );
								System.out.println(" 2 -> SALIR DEL PROGRAMA" );
								System.out.println("\n Seleccione una Opcion ");
								System.out.print(" ");
								eleccion = oD.numero();
								if(eleccion==1)
								{
									conteo = 0;
								}
								else if (eleccion==2)
								{
									conteo++;
									System.out.println("\n NOS VEMOS ! VUELVA PRONTO ");
								}
								else
								{
									System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
									System.out.println(" VUELVA A INTENTARLO ! ");
								}
							}	while((eleccion!=1)&&(eleccion!=2));
							break;//REPORTE	

						case 6:
								conteo++;
								retornar = 0;
							break;//REGRESAR

						default:
							System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
							System.out.println(" VUELVA A INTENTARLO ! ");
							conteo=0;
							retornar++;
							break;//default	
					}
						}while(conteo==0);
				break;//PRODUCTOS	

			case 3:
				do
				{
					conteo = 0;
					System.out.println("\n -FACTURACION- \n");
					System.out.println(" |MENU DE OPCIONES| ");
					System.out.println("  1 -> Realizar Factura ");
					System.out.println("  2 -> Buscar Factura");
					System.out.println("  3 -> Eliminar Factura ");
					System.out.println("  4 -> Reporte de Facturas" );
					System.out.println("  5 -> REGRESAR AL MENU \n");
					System.out.println(" Seleccione una Opcion ");
					System.out.print(" ");
					eleccion = oD.numero();
					
					switch(eleccion)
					{ 
							case 1:
								retornar++;
								System.out.println("\n *REALIZAR FACTURA* ");
								do
								{
									facturar = 0;
									do
									{
										System.out.println("\n EL CLIENTE POSEE CODIGO ");
										System.out.println("  1 -> SI POSEE ");
										System.out.println("  2 -> NO POSEE ");
										System.out.println("\n Seleccione una Opcion ");
										System.out.print(" ");
										eleccion = oD.numero();
										if (eleccion == 1)
										{
											cF.formatoFacturacionConCodigo();
										}
										else if (eleccion == 2)
										{
											cF.formatoFacturacionSinCodigo();
										}
										else if((eleccion!=1)&&(eleccion!=2))
										{
											System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
											System.out.println(" VUELVA A INTENTARLO ! ");
										}
									}	while((eleccion!=1)&&(eleccion!=2));
									do
									{
										System.out.println("\n DESEA REALIZAR OTRA FACTURA ");
										System.out.println(" 1 -> SEGUIR FACTURANDO " );
										System.out.println(" 2 -> REGRESAR AL SUBMENU " );
										System.out.print(" ");
										eleccion = oD.numero();
										if(eleccion == 1)
										{
											facturar = 0;
											conteo++;
										}									
										else if (eleccion == 2)
										{
											facturar++;
											conteo = 0;
										}
										else if ((eleccion!=1)&&(eleccion!=2))
										{
											System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
											System.out.println(" VUELVA A INTENTARLO ! ");
											conteo++;
											facturar++;
										}
									}	while(((eleccion!=1)&&(eleccion!=2)));
								}	while(facturar == 0);
								break;//REALIZAR FACTURA		
				

							case 2:
								retornar++;
								System.out.println("\n *BUSCAR* ");
								do
								{	
									cF.buscarFactura();
									do
									{
										System.out.println("\n DESEA BUSCAR MAS FACTURAS ");
										System.out.println(" 1 -> SEGUIR BUSCANDO" );
										System.out.println(" 2 -> REGRESAR AL SUBMENU" );
										System.out.print(" ");
										eleccion = oD.numero();
										conteo++;
										if(((eleccion!=1))&&((eleccion!=2)))
										{
											System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
											System.out.println(" VUELVA A INTENTARLO ! ");
										}
									}	while((eleccion!=1)&&(eleccion!=2));	
									if(eleccion == 2)
									{		
										conteo=0;
									}
							}	while(eleccion==1);

								break; //BUSCAR	FACTURA

							case 3:
								retornar++;
								System.out.println("\n *ELIMINAR* ");
								do
								{	
									cF.eliminarFactura();
									do
									{
										System.out.println("\n DESEA ELIMINAR MAS FACTURAS ");
										System.out.println(" 1 -> SEGUIR ELIMINANDO" );
										System.out.println(" 2 -> REGRESAR AL SUBMENU" );
										System.out.print(" ");
										eleccion = oD.numero();
										conteo++;
										if(((eleccion!=1))&&((eleccion!=2)))
										{
											System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
											System.out.println(" VUELVA A INTENTARLO ! ");
										}
									}	while((eleccion!=1)&&(eleccion!=2));	
									if(eleccion == 2)
									{		
										conteo=0;
									}
								}	while(eleccion==1);
								break; //ELIMINAR FACTURA

							case 4:
								retornar++;
								System.out.println("\n *REPORTE DE FACTURAS* ");
								cF.reporteFactura();
								do
								{
									System.out.println(" |OPCIONES| ");
									System.out.println(" 1 -> REGRESAR AL SUBMENU" );
									System.out.println(" 2 -> SALIR DEL PROGRAMA" );
									System.out.println("\n Seleccione una Opcion ");
									System.out.print(" ");
									eleccion = oD.numero();
									if(eleccion==1)
									{
										conteo = 0;
									}
									else if (eleccion==2)
									{
										conteo++;
										System.out.println("\n NOS VEMOS ! VUELVA PRONTO ");
									}
									else
									{
										System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
										System.out.println(" VUELVA A INTENTARLO ! ");
									}
								}	while((eleccion!=1)&&(eleccion!=2));
								break;//REPORTE FACTURA

							case 5:
								conteo++;
								retornar = 0;
								break;	

							default:
							System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
							System.out.println(" VUELVA A INTENTARLO ! ");
							conteo=0;
							retornar++;
							break;//default		
					}
				
				}	while(conteo == 0); 


				break;//FACTURA

			case 4:
				do
				{
					System.out.println(" \n*SALIR DEL PROGRAMA* ");
					System.out.println("\n SEGURO QUE DESEA SALIR... ");
					System.out.println(" 1 -> SALIR DEL PROGRAMA " );
					System.out.println(" 2 -> REGRESAR AL MENU PRINCIPAL " );
					System.out.println("\n Seleccione una Opcion ");
					System.out.print(" ");
					eleccion = oD.numero();
					if(eleccion==1)
					{
						retornar++;	
						conteo++;
						System.out.println("\n NOS VEMOS ! VUELVA PRONTO ");
					}
					else if(eleccion==2)
					{
						retornar=0;
						conteo++;
					}
					else
					{
						retornar++;	
						conteo++;
						System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
						System.out.println(" VUELVA A INTENTARLO ! ");
					}
				}	while((eleccion!=1)&&(eleccion!=2));	
				break;//SALIR

			default:
			System.out.println("\n LA OPCION ELEGIDA NO ES VALIDA ");
			System.out.println(" VUELVA A INTENTARLO ! ");
			retornar=0;
			conteo++;
			break;//default	
		}
		}while(retornar==0);
	}
}
