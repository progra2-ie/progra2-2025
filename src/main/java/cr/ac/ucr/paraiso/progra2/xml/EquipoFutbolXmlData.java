package cr.ac.ucr.paraiso.progra2.xml;

/*import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;*/

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class EquipoFutbolXmlData {
	private Document document;
	private Element raiz;
	private String rutaDocumento;
	
	// Constructor que se encarga de crear el DOM y el Documento XML
	private EquipoFutbolXmlData(String rutaDocumento, String nombreRaiz)
			throws	FileNotFoundException, IOException{
		this.rutaDocumento = rutaDocumento;
		this.raiz = new Element(nombreRaiz);
		this.document = new Document(raiz);
		guardar();
		
	}

	// Constructor que se encarga de parsear el Documento XML a un DOM
	private EquipoFutbolXmlData(String rutaDocumento) throws
			JDOMException, IOException{
			SAXBuilder saBuilder = new SAXBuilder();
			saBuilder.setIgnoringElementContentWhitespace(true);
			//parseo
			this.document = saBuilder.build(rutaDocumento);
			this.raiz = document.getRootElement();
			this.rutaDocumento = rutaDocumento;
	}
	
	public static EquipoFutbolXmlData abrirDocumento(String rutaDocumento)
			throws JDOMException, IOException{
		if (new File(rutaDocumento).exists() == true) {
			return new EquipoFutbolXmlData(rutaDocumento);
		}else return new EquipoFutbolXmlData(rutaDocumento, "equipos");

	}
	
	public void guardar() throws FileNotFoundException, IOException{
		Format format = Format.getPrettyFormat();
		format.setEncoding("UTF-8"); // Es buena práctica especificar la codificación
		XMLOutputter xmlOutputter = new XMLOutputter();
		PrintWriter printWriter = new PrintWriter(this.rutaDocumento);
		xmlOutputter.output(this.document,  printWriter);
		printWriter.close(); // cerrarlo
		
		// imprimir en la consola el DOM
		xmlOutputter.output(this.document, System.out);

	}

	public void insertarEquipo(EquipoFutbol equipoFutbol) throws  IOException{
		Element eEquipo = new Element("equipoFutbol");
		eEquipo.setAttribute("codEquipo", equipoFutbol.getCodEquipo());
		Element eNombre = new Element("nombre");
		eNombre.addContent(equipoFutbol.getNombre());
		
		Element eCantidadJugadoresInscritos = new Element("cantidadJugadoresInscritos");
		eCantidadJugadoresInscritos.addContent(
				String.valueOf(equipoFutbol.getCantidadJugadoresInscritos()));
		
		eEquipo.addContent(eNombre);
		eEquipo.addContent(eCantidadJugadoresInscritos);
		raiz.addContent(eEquipo);
		guardar();
	}//insertarEquipo

	public ArrayList<EquipoFutbol> getEquipos(){
		// retorna el numero de hijos raiz.getContentSize()
		List<Element> eListaEquipos = raiz.getChildren(); // OJO una lista de OBJETOS TIPO Element
		ArrayList<EquipoFutbol> equipos = new ArrayList<EquipoFutbol>();
		for(Element eEquipo:eListaEquipos){
			EquipoFutbol equipoActual = new EquipoFutbol();
			equipoActual.setCodEquipo(eEquipo.getAttributeValue("codEquipo"));
			equipoActual.setNombre(eEquipo.getChildText("nombre"));
			equipoActual.setCantidadJugadoresInscritos(
					Integer.parseInt(eEquipo.getChildText("cantidadJugadoresInscritos")));
			equipos.add(equipoActual);
		}
		return equipos;
	}//getEquipos
}







