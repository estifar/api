package med.voll.api.domain.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.direccion.Direccion;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    private Boolean activo; // Campo booleano

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @Embedded
    private Direccion direccion;

    public Medico(DatosRegistroMedico datosRegistroMedico) {
        this.activo = true; // valor por defecto
        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.telefono = datosRegistroMedico.telefono();
        this.documento = datosRegistroMedico.documento();
        this.especialidad = datosRegistroMedico.especialidad();
        this.direccion = new Direccion(datosRegistroMedico.direccion());
    }

    public void actualizarDatos(ActualizarDatosMedico actualizarDatosMedico) {
        if (actualizarDatosMedico.nombre() != null){
            this.nombre = actualizarDatosMedico.nombre();
        }
        if (actualizarDatosMedico.documento() != null){
            this.documento = actualizarDatosMedico.documento();
        }
        if (actualizarDatosMedico.direccion() != null){
            this.direccion = direccion.actualizarDatos(actualizarDatosMedico.direccion());
        }
    }

    public void desactivarMedico() {
        this.activo = false;
    }
}
