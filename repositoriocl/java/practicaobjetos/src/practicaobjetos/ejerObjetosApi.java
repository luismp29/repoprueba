package practicaobjetos;

import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ejerObjetosApi 
{
	FileSystem file = FileSystems.getDefault();
	Path ruta = file.getPath("./src/practicaobjetos/FicheroVehiculos/vehiculos.txt");
	
public static void main(String[] args)
{
	//dos objetos son iguales si marca modelo y precio son iguales.
	
	ejerObjetosApi obj=new ejerObjetosApi();
	
	HashSet<ejerObjetos> lista = obj.hashSetVehiculos();
	if(!obj.fichero(lista)) System.out.println("Problemas al crear el hashset");
	else
		System.out.println("Exito al guardar el hashset");

}


	public HashSet<ejerObjetos> hashSetVehiculos()
	{
	
		ejerObjetos camion=new ejerObjetos("Man", "brisco", "blanco", 5, 12, 50234.56);
		ejerObjetos camion2=new ejerObjetos("Man", "brisco", "blanco", 2, 8, 50234.56);
		ejerObjetos todoterreno=new ejerObjetos("jeep", "wrangler", "azul", 5, 5, 40104.26);
		ejerObjetos turismo=new ejerObjetos("wolfkswagen", "siroco", "marron", 3, 5, 9104.26);
		ejerObjetos todoterreno2=new ejerObjetos("jeep", "wrangler", "blanco", 5, 5, 40104.26);
		ejerObjetos motocicleta=new ejerObjetos("harley davidson", "dakota", "negra", 0, 2, 60000.00);
		
		HashSet<ejerObjetos> listaVehiculos=new HashSet<>();
		
		listaVehiculos.add(camion);
		listaVehiculos.add(camion2);
		listaVehiculos.add(todoterreno);
		listaVehiculos.add(turismo);
		listaVehiculos.add(todoterreno2);
		listaVehiculos.add(motocicleta);
		
		return listaVehiculos;
	
	}
	
	public boolean fichero(HashSet<ejerObjetos> h)
	{
		boolean resul = false;
		
		if(Files.notExists(file.getPath("./src/practicaobjetos/FicheroVehiculos")))
		{
			try
			{
				Files.createDirectories(file.getPath("./src/practicaobjetos/FicheroVehiculos"));
				Files.createFile(ruta);
			}
			catch (IOException A)
			{
				A.getMessage();
				return resul;
			}
		}
		
		int siize = h.size();
		int indx = 1;
		try(BufferedWriter bw = Files.newBufferedWriter(ruta, Charset.defaultCharset(), StandardOpenOption.APPEND))
		{
			for(ejerObjetos x: h) //for each para guardar y decidir en que fichero guardarlo
			{
				//bw.write(x.getMarca()+"*"+x.getModelo()+"*"+x.getColor()+"*"+x.getPuertas()+"*"+x.getRuedas()+"*"+x.getPrecio());
				bw.write(x.toString());//creado tostring de la clase que heredo
				
				if(indx < siize)
				{
					bw.newLine();
					indx++;
				}
				
			}
		}
		catch (IOException e) 
		{
			e.getMessage();
			return resul;
		}
		return true;
		
	}

}