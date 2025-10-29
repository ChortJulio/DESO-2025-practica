package repository.dominio;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Pasajero {
    private Long id;
    private String nombre;
    private String apellido;
    private Direccion direccion;
}