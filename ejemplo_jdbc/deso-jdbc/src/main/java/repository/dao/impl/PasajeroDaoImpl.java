package repository.dao.impl;

import repository.JDBCConnector;
import repository.dao.PasajeroDao;
import repository.dominio.Direccion;
import repository.dominio.Pasajero;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class PasajeroDaoImpl implements PasajeroDao {

    public final JDBCConnector jdbcConnector;

    public PasajeroDaoImpl(JDBCConnector jdbcConnector) {
        this.jdbcConnector = jdbcConnector;
    }

    @Override
    public Optional<Pasajero> getPasajeroById(Long id) {
        String query = "SELECT * FROM pasajeros p WHERE ? = p.id";
        try (PreparedStatement statement = jdbcConnector.prepareQuery(query)) {
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            if (!result.next()) {
                return Optional.empty();
            }
            var pasajero = Pasajero.builder()
                    .id(result.getLong("id"))
                    .nombre(result.getString("nombre"))
                    .apellido(result.getString("apellido"))
                    .direccion(Direccion.builder()
                            .calle(result.getString("calle"))
                            .numero(result.getInt("numero"))
                            .build())
                    .build();
            return Optional.of(pasajero);
        } catch (SQLException e) {
            System.out.println("Error buscando pasajero");
        }
        return Optional.empty();
    }

    @Override
    public Pasajero savePasajero(Pasajero p) {
        String query = "INSERT INTO pasajeros (nombre, apellido, calle, numero) VALUES (?,?,?,?)";
        try (PreparedStatement statement = jdbcConnector.prepareQuery(query)) {
            statement.setString(1, p.getNombre());
            statement.setString(2, p.getApellido());
            statement.setString(3, p.getDireccion().getCalle());
            statement.setInt(4, p.getDireccion().getNumero());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Error guardando pasajero");
            System.out.println(e.getMessage());
        }
        return null;
    }
}
