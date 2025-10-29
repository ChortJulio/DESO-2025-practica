package repository.dominio;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Direccion {
    private String calle;
    private Integer numero;
}
