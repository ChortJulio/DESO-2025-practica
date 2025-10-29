package repository.dao;

import repository.dominio.Pasajero;

import java.util.Optional;

public interface PasajeroDao {
    Optional<Pasajero> getPasajeroById(Long id);
    Pasajero savePasajero(Pasajero p);
}
