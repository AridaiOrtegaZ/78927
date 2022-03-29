package mx.uv.t4is.saludos;

import java.util.ArrayList;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import https.t4is_uv_mx.saludos.SaludarResponse;
import https.t4is_uv_mx.saludos.BuscarSaludosResponse.Saludos;
import https.t4is_uv_mx.saludos.BorrarSaludoRequest;
import https.t4is_uv_mx.saludos.BorrarSaludoResponse;
import https.t4is_uv_mx.saludos.BuscarSaludosResponse;
import https.t4is_uv_mx.saludos.ModificarSaludoRequest;
import https.t4is_uv_mx.saludos.ModificarSaludoResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;

@Endpoint
public class SaludosEndPoint {
    int id=0;
    ArrayList<Saludos> saludos = new ArrayList<>();
    @PayloadRoot (namespace = "https://t4is.uv.mx/saludos", localPart = "SaludarRequest")
    
    @ResponsePayload
    public SaludarResponse saludar(@RequestPayload SaludarRequest nombre){
        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("Hola " + nombre.getNombre());
        //BuscarSaludosResponse.Saludos saludo = new BuscarSaludosResponse.Saludos();
        Saludos e = new Saludos();
        e.setId(id++);
        e.setNombre("Hola " + nombre.getNombre());
        saludos.add(e);
        return respuesta;
    }

    @PayloadRoot (namespace = "https://t4is.uv.mx/saludos", localPart = "BuscarSaludosRequest")
    @ResponsePayload
    public BuscarSaludosResponse buscar(){
        BuscarSaludosResponse respuesta = new BuscarSaludosResponse();
        //implementar la devolucion de la lista. Agregar el saludo a una lista
        for (Saludos s : saludos){
            respuesta.getSaludos().add(s);
        }
        return respuesta;
    }

@PayloadRoot(namespace = "https://t4is.uv.mx/saludos", localPart = "ModificarSaludoRequest")
//Conversion de objeto  xml
@ResponsePayload
//conversión de xml a objeto
public ModificarSaludoResponse modificar(@RequestPayload ModificarSaludoRequest peticion){
	ModificarSaludoResponse respuesta = new ModificarSaludoResponse();
	
	Saludos b = new Saludos();
    b.setNombre(peticion.getNombre());
    b.setId(peticion.getId());
	saludos.set(peticion.getId()-1,b);
	respuesta.setRespuesta(true);
	return respuesta;
}

@PayloadRoot(namespace = "https://t4is.uv.mx/saludos", localPart = "BorrarSaludoRequest")
//Conversion de objeto  xml
@ResponsePayload
//conversión de xml a objeto
public BorrarSaludoResponse modificar(@RequestPayload BorrarSaludoRequest peticion){
	BorrarSaludoResponse respuesta = new BorrarSaludoResponse();
	
	Saludos e = new Saludos();
    e.setId(peticion.getId());
	saludos.remove(peticion.getId()-1);
	respuesta.setRespuesta(true);
	return respuesta;
} 
}
