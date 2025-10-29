package service;

import repository.dao.PasajeroDao;
import repository.dominio.Pasajero;

public class PasajeroService {

    public final PasajeroDao pasajeroDao;

    public PasajeroService(PasajeroDao pasajeroDao) {
        this.pasajeroDao = pasajeroDao;
    }

    public Pasajero buscarPasajero(Long id) throws Exception {
        if (id < 1) {
            throw new IllegalArgumentException("id invalido");
        }

        return pasajeroDao.getPasajeroById(id).orElseThrow(
                () -> new Exception("pasajero no encontrado"));
    }
}
