import dao.BD;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;

public class OdontologoTestService {

    @Test
    public void buscarOdontologos(){
        BD.crearTablas();
        OdontologoService odontologoService = new OdontologoService();
        Integer busqueda = 1;
        Odontologo odontologo = odontologoService.buscarOdontologo(busqueda);
        List<Odontologo> odontologosLista = odontologoService.buscarTodos();
       Assertions.assertTrue(odontologosLista!=null);
       Odontologo nuevoOdontologo = new Odontologo(3213, "Pepe", "Mendonza");
    }
}
