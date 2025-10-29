package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.dao.PasajeroDao;
import repository.dominio.Pasajero;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PasajeroServiceTest {

    @Mock
    PasajeroDao pasajeroDao;
    @InjectMocks
    PasajeroService pasajeroService;

    @Test
    void buscarPasajero_invalidId_throws() {
        // Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> pasajeroService.buscarPasajero(-1L));
    }

    @Test
    void buscarPasajero_nonExistentId_throws() {
        // Arrange
        Long id = 123L;
        Mockito.when(pasajeroDao.getPasajeroById(id)).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(Exception.class, () -> pasajeroService.buscarPasajero(id));
    }

    @Test
    void buscarPasajero_found_returnsPasajero() throws Exception {
        // Arrange
        Long id = 123L;
        Pasajero pasajero = Pasajero.builder().id(id).build();
        Mockito.when(pasajeroDao.getPasajeroById(Mockito.anyLong()))
                .thenReturn(Optional.ofNullable(pasajero));

        // Act
        Pasajero p = pasajeroService.buscarPasajero(id);

        // Assert
        Assertions.assertEquals(id, p.getId());
    }
}
