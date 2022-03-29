package mx.uv.t4is.SaludosBd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludosdb.SaludarResponse;
import https.t4is_uv_mx.saludosdb.BorrarSaludoRequest;
import https.t4is_uv_mx.saludosdb.BorrarSaludoResponse;
import https.t4is_uv_mx.saludosdb.BuscarSaludosResponse;
import https.t4is_uv_mx.saludosdb.ModificarSaludoRequest;
import https.t4is_uv_mx.saludosdb.ModificarSaludoResponse;
import https.t4is_uv_mx.saludosdb.SaludarRequest;



@Endpoint
public class SaludosEndPoint {
    //int i=1;
    //private List<BuscarSaludosResponse.Saludos> saludos = new ArrayList<BuscarSaludosResponse.Saludos>();
    @Autowired
    private Isaludadores isaludadores; 
    
    @PayloadRoot(namespace = "https://t4is.uv.mx/SaludosDb", localPart = "SaludarRequest")
    @ResponsePayload
    public SaludarResponse saludar(@RequestPayload SaludarRequest nombre){
        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("Hola" + nombre.getNombre());
        Saludadores s = new Saludadores();//BuscarSaludosResponse.Saludos s = new BuscarSaludosResponse.Saludos();
        //s.setId(generarCodigo());
        s.setNombre(nombre.getNombre());
        isaludadores.save(s); //saludos.add(s);
        return respuesta;
    }


    @PayloadRoot(namespace = "https://t4is.uv.mx/SaludosDb", localPart = "BuscarSaludosRequest")
    @ResponsePayload
    public BuscarSaludosResponse buscar(){
        BuscarSaludosResponse buscarSaludosResponse = new BuscarSaludosResponse();
        Iterable<Saludadores> saludadores = isaludadores.findAll();

        saludadores.forEach(isaludo -> {
            Saludo saludo = new Saludo();
            saludo.setId(isaludo.getId());
            saludo.setNombre(isaludo.getNombre());
            respuesta.getSaludo().add(saludo);
        });
        return buscarSaludosResponse;
    }


    @PayloadRoot(namespace = "https://t4is.uv.mx/SaludosDb", localPart="ModificarSaludoRequest")
    @ResponsePayload
    public ModificarSaludoResponse modificar(@RequestPayload ModificarSaludoRequest peticion){
        ModificarSaludoResponse respuesta = new ModificarSaludoResponse();
        int id = peticion.getId();
        String nombre = peticion.getNombre();

        Optional<Saludadores> oSaludador = isaludadores.findById(id);
        if(oSaludador.isPresent()) {
            Saludadores saludador;
            saludador = oSaludador.get();
            saludador.setNombre(nombre);
            isaludadores.save(saludador);
            respuesta.setRespuesta(true);
        } else {
            respuesta.setRespuesta(false);
        }
        return respuesta;
    }

    @PayloadRoot(namespace = "https://t4is.uv.mx/SaludosDb", localPart="BorrarSaludoRequest")
    @ResponsePayload
    public BorrarSaludoResponse modificar(@RequestPayload BorrarSaludoRequest peticion){
        BorrarSaludoResponse respuesta = new BorrarSaludoResponse();
        isaludadores.deleteById(peticion.getId());
        respuesta.setRespuesta(true);
        return respuesta;
    }

}
