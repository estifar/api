package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.direccion.DatosDireccion;

public record ActualizarDatosMedico(
        @NotNull Long Id,
        String nombre,
        String documento,
        DatosDireccion direccion) {
}
