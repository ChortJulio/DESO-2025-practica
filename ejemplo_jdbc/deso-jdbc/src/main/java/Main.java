import repository.JDBCConnector;
import repository.dao.PasajeroDao;
import repository.dao.impl.PasajeroDaoImpl;
import repository.dominio.Direccion;
import repository.dominio.Pasajero;
import service.PasajeroService;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws Exception {
        PasajeroDao pasajeroDao = new PasajeroDaoImpl(JDBCConnector.getInstance());
        Pasajero nuevo = Pasajero.builder()
                .nombre("pepe")
                .apellido("pepito")
                .direccion(Direccion.builder()
                        .numero(1235)
                        .calle("calle falsa")
                        .build())
                .build();
        pasajeroDao.savePasajero(nuevo);

        pasajeroDao.getPasajeroById(5L).ifPresent(p ->
                System.out.println("busqueda de id 5: PASAJERO ENCONTRADO :)"));
        pasajeroDao.getPasajeroById(1L).ifPresent(p ->
                System.out.println("busqueda de id 1: PASAJERO ENCONTRADO :)"));


        var pasajeroService = new PasajeroService(pasajeroDao);
        pasajeroService.buscarPasajero(200L);
    }
}
