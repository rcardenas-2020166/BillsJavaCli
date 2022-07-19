
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ObtenerDatos
{
	 int num = 0;
	 int op = 0;
	 String dato = null;
	 double decimal = 0;
	 char caracter;

	
	//NUMERO//
	public int numero ()
	{
		BufferedReader leer = new BufferedReader (new InputStreamReader(System.in));
		try 
		{
			num = Integer.parseInt(leer.readLine());
			
		}
		catch(IOException e)
		{
			System.out.println ("ERROR IOE");
			System.exit(1);
		}
		return num;
	}

	//TEXTO//
	public String texto ()
	{
		BufferedReader bR = new BufferedReader (new InputStreamReader(System.in));
		try 
		{
			dato = bR.readLine();
		}
		catch(IOException ioe)
		{
			System.out.println ("ERROR IOE");
			System.exit(1);
		}
		return dato;
	}

	//DECIMALES//
	public double decimal ()
	{
		BufferedReader leer = new BufferedReader (new InputStreamReader(System.in));
		try 
		{
			decimal = Double.parseDouble(leer.readLine());
			
		}
		catch(IOException e)
		{
			System.out.println ("ERROR IOE");
			System.exit(1);
		}
		return decimal;
	}

	//CHAR//
	public char caracter()
	{
		BufferedReader leer = new BufferedReader (new InputStreamReader(System.in));
		try 
		{
			caracter = (char)leer.read();
			
		}
		catch(IOException e)
		{
			System.out.println ("ERROR IOE");
			System.exit(1);
		}
		return caracter;
	}
}
