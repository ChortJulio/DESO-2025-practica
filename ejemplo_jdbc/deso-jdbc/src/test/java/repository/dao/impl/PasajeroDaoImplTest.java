package repository.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.JDBCConnector;
import repository.dominio.Pasajero;

import java.sql.*;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PasajeroDaoImplTest {

    @Mock
    JDBCConnector jdbcConnector;
    @InjectMocks
    PasajeroDaoImpl pasajeroDao;

    @Test
    void getPasajeroById_failPreparingQuery_returnsEmpty() throws Exception {
        // Arrange
        Mockito.when(jdbcConnector.prepareQuery(Mockito.anyString()))
                .thenThrow(SQLException.class);
        // Act
        Optional<Pasajero> pasajero = pasajeroDao.getPasajeroById(10L);

        // Assert
        Assertions.assertTrue(pasajero.isEmpty());
    }
}
