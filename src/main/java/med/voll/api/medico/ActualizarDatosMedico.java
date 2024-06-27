package med.voll.api.medico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.direccion.DatosDireccion;

public record ActualizarDatosMedico(
        @NotNull Long Id,
        String nombre,
        String documento,
        DatosDireccion direccion) {
}
