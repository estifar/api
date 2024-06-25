package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.direccion.DatosDireccion;

public record DatosRegistroMedico(
        @NotBlank
        String nombre,

        @NotBlank
        String email,

        @NotBlank
        String telefono,

        @Pattern(regexp = "\\d{4,6}", message = "debe tener entre 4 y 6 dígitos")
        String documento,

        @NotNull
        Especialidad especialidad,

        @NotNull
        @Valid
        DatosDireccion direccion) {
}