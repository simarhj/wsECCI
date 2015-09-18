/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ESTACION
 */
@WebService(serviceName = "ServicioWeb")
public class ServicioWeb {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "calcularEdad")
    public String calcularEdad(@WebParam(name = "fechaNacimiento") String fechaNacimiento) {
        Date ahora = new Date(System.currentTimeMillis());
        String respuesta = "A la fecha de hoy "+ahora.toString();
        Date fecha = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fecha = df.parse(fechaNacimiento);
        } catch (Exception e) {
            respuesta+="\n calculo no es posible por el formato de la fecha";
        }
        long edad = (ahora.getTime()-fecha.getTime())/(3600*24*365)/1000;
        respuesta+="\nSu edad es: "+edad;
        return respuesta;
    }
}
