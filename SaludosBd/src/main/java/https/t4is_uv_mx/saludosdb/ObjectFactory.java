//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.03.29 a las 11:38:20 AM CST 
//


package https.t4is_uv_mx.saludosdb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.t4is_uv_mx.saludosdb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BuscarSaludosRequest_QNAME = new QName("https://t4is.uv.mx/SaludosDb", "BuscarSaludosRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.t4is_uv_mx.saludosdb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BuscarSaludosResponse }
     * 
     */
    public BuscarSaludosResponse createBuscarSaludosResponse() {
        return new BuscarSaludosResponse();
    }

    /**
     * Create an instance of {@link SaludarRequest }
     * 
     */
    public SaludarRequest createSaludarRequest() {
        return new SaludarRequest();
    }

    /**
     * Create an instance of {@link SaludarResponse }
     * 
     */
    public SaludarResponse createSaludarResponse() {
        return new SaludarResponse();
    }

    /**
     * Create an instance of {@link BuscarSaludosResponse.Saludos }
     * 
     */
    public BuscarSaludosResponse.Saludos createBuscarSaludosResponseSaludos() {
        return new BuscarSaludosResponse.Saludos();
    }

    /**
     * Create an instance of {@link ModificarSaludoRequest }
     * 
     */
    public ModificarSaludoRequest createModificarSaludoRequest() {
        return new ModificarSaludoRequest();
    }

    /**
     * Create an instance of {@link ModificarSaludoResponse }
     * 
     */
    public ModificarSaludoResponse createModificarSaludoResponse() {
        return new ModificarSaludoResponse();
    }

    /**
     * Create an instance of {@link BorrarSaludoRequest }
     * 
     */
    public BorrarSaludoRequest createBorrarSaludoRequest() {
        return new BorrarSaludoRequest();
    }

    /**
     * Create an instance of {@link BorrarSaludoResponse }
     * 
     */
    public BorrarSaludoResponse createBorrarSaludoResponse() {
        return new BorrarSaludoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://t4is.uv.mx/SaludosDb", name = "BuscarSaludosRequest")
    public JAXBElement<Object> createBuscarSaludosRequest(Object value) {
        return new JAXBElement<Object>(_BuscarSaludosRequest_QNAME, Object.class, null, value);
    }

}
