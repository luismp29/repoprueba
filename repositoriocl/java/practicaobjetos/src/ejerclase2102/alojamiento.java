package ejerclase2102;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Stream;


public class alojamiento extends clienteHotel
{

	public static void main(String[] args)
	{
		
		FileSystem file = FileSystems.getDefault();
		Path rutaH = file.getPath("./src/ejerclase2102/hotel.txt");
		Path rutaC = file.getPath("./src/ejerclase2102/cliente.txt");
		Path rutaA = file.getPath("./src/ejerclase2102/alojamiento.txt");
		ArrayList <String> listaC = new ArrayList<>();
		ArrayList <String> listaH = new ArrayList<>();
		alojamiento objmetodos = new alojamiento();
		
		//aplico los metodos para leer y añadir los ficheros x string a los arraylist
		objmetodos.leer1(rutaH, listaH);
		objmetodos.leer2(rutaC, listaC);
		//imprimo los arraylist para comprobar que se han guardado correctamente
		System.out.println(listaC);
		System.out.println(listaH);
		
		ArrayList <String> aloja = new ArrayList<>();// me creo un arraylist tipo string
		for(String s: listaH) //utilizo la forma lambda  para dividr los sub y usar los atributos
		{
			String nombreH = s.substring(0,s.indexOf("*"));
			String cadena = s.substring(s.indexOf("*")+1);
			String codeH = cadena.substring(cadena.indexOf("*")+1);
			
			for(String x: listaC)
			{
				String nombreC = x.substring(0,x.indexOf("*"));
				cadena = x.substring(x.indexOf("*")+1);
				String apellidoC = cadena.substring(0,cadena.indexOf("*"));
				String codeC = cadena.substring(cadena.indexOf("*")+1);
				if(codeH.equals(codeC)) //igualo ambos codigos
				{
					switch(codeC)//segun el codigo que me los añada
					{
					case "c01":
						String c01 = nombreH+"*"+nombreC+"*"+apellidoC;//me creo un string donde me añade lo que quiero segun el codigo
						aloja.add(c01);
						break;
					case "c02":
						String c02 = nombreH+"*"+nombreC+"*"+apellidoC;
						aloja.add(c02);
						break;
					case "c03":
						String c03 = nombreH+"*"+nombreC+"*"+apellidoC;
						aloja.add(c03);
						break;
					case "c04":
						String c04 = nombreH+"*"+nombreC+"*"+apellidoC;
						aloja.add(c04);
						break;
					}
				}
				
			}
		}
		Collections.sort(aloja);//ordeno segun nombre y si son iguales segun nombre del cliente
		System.out.println(aloja);//lo imprimo para comprobar
		String [] prueba = new String [aloja.size()];//me creo un array tipo string para meter los datos del arraylist
		aloja.toArray(prueba);//le paso los datos
		
		if(Files.exists(file.getPath("./src/ejerclase2102")))//si existe el directorio
		{
			try
			{
				//que me cree el alojamiento.txt
				Files.createFile(rutaA);
			}
			catch (IOException A)
			{
				A.getMessage();
			}
		}
		try(BufferedWriter br = Files.newBufferedWriter(rutaA, Charset.forName("UTF-8"), StandardOpenOption.WRITE)) //br es un buffer
		{//utilizo el array tipo string que me cree para que me pase los datos al fichero
			Arrays.stream(prueba).forEach(s -> //array de tipo string donde for each los recorre cada s(string)
			{
				try //lo que quiero es escribirlo asi que lo meto dentro de un try
				{
					br.write(s);
					br.newLine();; 
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			});
		}
		catch(IOException a)
		{
			a.getMessage();
		}

	}

	public ArrayList <String> leer1(Path x, ArrayList <String> a)
	{
		try(Stream<String> flujo = Files.lines(x, Charset.forName("UTF-8"))) //el texto que esta recibiendo lo trata como utf-8, lee el fichero y o añade en el flujo
		{
			flujo.forEach((String s) -> a.add(s)); //por cada string que se reciba lo imprime
		}
		catch (IOException e)//con ficheros siempre se usa IOException
		{
			e.printStackTrace();
		}
		
		return a;
	}
	
	public ArrayList <String> leer2(Path x, ArrayList <String> a)
	{
		try(Stream<String> flujo = Files.lines(x, Charset.forName("UTF-8"))) //el texto que esta recibiendo lo trata como utf-8, lee el fichero y o añade en el flujo
		{
			flujo.forEach((String s) -> a.add(s)); //por cada string que se reciba lo imprime
		}
		catch (IOException e)//con ficheros siempre se usa IOException
		{
			e.printStackTrace();
		}
		
		return a;
	}
	
}

