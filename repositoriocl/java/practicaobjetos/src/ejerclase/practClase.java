package ejerclase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

//creamos clase maderas, atributos: string(nombre, color, arbol,) int densidad, double preciom3,  string dureza
//dos objetos distintos si densidad, preciom3 y dureza son distintos
//array list 10 maderas, 4 de ellas repetidas -> (densidad preciom3 y dureza) //ordenarlas por nombre
//añadimos a un hashset las 10 maderas del arraylist
//creamos un directorio que se llame dirmaderas, dentro un directorio que se llame farraylist.txt donde metemos los elementos del arraylist
//y fhashset.txt donde añadimos los elemetos del hashset
//listamos ambos ficheros
//dentro del fichero * color * arbol * densidad * premio* 

public class practClase 
{	
	
	public static void main(String[] args) 
	{
		//me creo el filessystem y los path
		FileSystem file = FileSystems.getDefault();
		Path rutafA = file.getPath("./src/ejerclase/dirmaderas/farraylist.txt");
		Path rutafH = file.getPath("./src/ejerclase/dirmaderas/fhashset.txt");
		
		ArrayList<madera> lista = new ArrayList<>();//me creo el list y le añado los objetos
		lista.add(new madera("abeto", "negro", "abeto", 5, 6.75, "poca"));
		lista.add(new madera("pino", "marron", "pino", 10, 9.45, "mucha"));
		lista.add(new madera("roble", "beige", "roble", 4, 8.14, "media"));
		lista.add(new madera("fresno", "marron claro", "fresno", 2, 12.45, "mucha"));
		lista.add(new madera("nogal", "chocolate", "nogal", 14, 3.33, "poca"));
		lista.add(new madera("cerezo", "cacao", "cerezo", 11, 8.95, "media"));
		lista.add(new madera("caoba", "gris", "caoba", 5, 6.75, "poca"));
		lista.add(new madera("teca", "marron oscuro", "teca", 5, 6.75, "poca"));
		lista.add(new madera("arce", "blanco", "arce", 5, 6.75, "poca"));
		lista.add(new madera("haya", "naranja", "haya", 14, 3.23, "mucha"));
		
		Collections.sort(lista);//para ordenarlos por nombre
		//Collections.sort(lista);//para ordenarlos por nombre al reves
		
		
		
		if(Files.notExists(file.getPath("./src/ejerclase/dirmaderas")))//que mire si existe primero
		{
			try
			{
				//si no existe que cree todo
				Files.createDirectories(file.getPath("./src/ejerclase/dirmaderas"));
				Files.createFile(rutafA);
				Files.createFile(rutafH);
			}
			catch (IOException A)
			{
				A.getMessage();
			}
		}
		
		if(Files.exists(rutafA))//si existe el direcorio
		{
				try(BufferedWriter bw = Files.newBufferedWriter(rutafA, Charset.forName("UTF-8"), StandardOpenOption.WRITE)) //me creo un buffer que es el que va a escribir el documento
				{
						try
						{
							for(madera v: lista) //utilizo un bucle para que lo escriba y haga el salto de linea ya que no tengo un buffer que lea
							{
								bw.write(v.toString());
								bw.newLine();
							}
						}
						catch (IOException A)
						{
							A.printStackTrace();
						}
						;
				}
				catch(IOException a)
				{
					a.printStackTrace();
				}
			
		}
		else
		{
			System.out.println("el directorio no existe");
		}
		
//****************************************************************		
		practClase obj = new practClase();
		HashSet <madera> xx =obj.hash(lista); //le paso el arametro del metodo para que me cree el set
		
		if(Files.exists(rutafH))
		{
				try(BufferedWriter bwfh = Files.newBufferedWriter(rutafH, Charset.forName("UTF-8"), StandardOpenOption.WRITE)) //.WRITE TE LO SOBREESCRIBE
				{
						try
						{
							for(madera x: xx)
							{
								bwfh.write(x.toString());
								bwfh.newLine();
							}
						}
						catch(IOException A)
						{
							A.getMessage();
						}
				}
				catch(IOException A)
				{
					A.getMessage();
				}
		}
		else
		{
			System.out.println("el directorio no existe");
		}
//***********************************************
		
		/*System.out.println("**Listo ArrayList**");
		System.out.println(lista);
		System.out.println("******************");
		System.out.println("**Listo HashSet**");
		/*Set<madera> listamadera = new TreeSet<madera>(xx); // con esto consigo que me lo imprima en orde pero no que lo guarde en el archivo en orden
		
		for(madera v: listamadera)
		{
			System.out.println(v);
		}*/
		System.out.println("**Listo ArrayList**");
		obj.imprimirFichero(rutafH);
		System.out.println("******************");
		System.out.println("**Listo HashSet**");
		obj.imprimirFichero(rutafA);
		
}
	
	
	
	
	
	
	public HashSet<madera> hash(ArrayList<madera> x)//le paso un parametro arraylist para que me pase los datos del arraylist al set
	{
		HashSet <madera> set = new HashSet<>();//me creo el set
		for(madera h:x)//igualo la variable list a una variable del tipo madera
		{
			set.add(h);//añadoo la variable igualada y se lo añado al set
		}
		
		return set;
		
	}
	
	public boolean imprimirFichero(Path x)
	{
		
		try(Stream <String> flujo = Files.lines(x, Charset.forName("UTF-8"))) //el texto que esta recibiendo lo trata como utf-8, lee el fichero y o añade en el flujo
		{
			flujo.forEach((String s) -> System.out.println(s)); //por cada string que se reciba lo imprime
		}
		catch (IOException e)//con ficheros siempre se usa IOException
		{
			e.printStackTrace();
		}
		return true;
		
	}
	

}
