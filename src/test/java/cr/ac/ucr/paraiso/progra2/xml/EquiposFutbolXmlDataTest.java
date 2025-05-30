package cr.ac.ucr.paraiso.progra2.xml;



import org.jdom2.JDOMException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class EquiposFutbolXmlDataTest {
	private EquipoFutbolXmlData equipoFutbolXmlData;

	@BeforeEach
	public void init(){
		try {
			equipoFutbolXmlData =
				EquipoFutbolXmlData.abrirDocumento("c:\\MyStuff\\equipos.xml");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterEach
	public void fin(){
		String rutaArchivo = "c:\\MyStuff\\equipos.xml";
		File file = new File(rutaArchivo);
		boolean borrado = file.delete();

		System.out.println(borrado);
	}
	
	@Test
	public void insertar_equipos(){
		//Assert
		EquipoFutbol equipo1, equipo2;
		equipo1 = new EquipoFutbol("NED", "Netherlands", 18);
		equipo2 = new EquipoFutbol("GER", "Gérmany", 18);

		// Act
		Assertions.assertDoesNotThrow(() -> {
					this.equipoFutbolXmlData.insertarEquipo(equipo1);
					this.equipoFutbolXmlData.insertarEquipo(equipo2);
		});

		ArrayList<EquipoFutbol> equipos = equipoFutbolXmlData.getEquipos();
		Assertions.assertEquals(2, equipos.size());
		Assertions.assertEquals("Netherlands", equipos.get(0).getNombre());
		/*for (Iterator<EquipoFutbol> iterator = equipos.iterator(); iterator.hasNext();) {
			EquipoFutbol equipoFutbol = iterator.next();
			System.out.println(equipoFutbol.getCodEquipo() + "- " +
					equipoFutbol.getNombre());

		}*/
	}

}
