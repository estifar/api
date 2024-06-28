package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    public void registrarMedico(@RequestBody @Valid DatosRegistroMedico datosRegistroMedico) {
        medicoRepository.save(new Medico(datosRegistroMedico));
    }

    @GetMapping
    public Page<DatosListadoMedico> listadomedicos(Pageable paginacion) {
        //return medicoRepository.findByActivoTrue(paginacion).map(DatosListadoMedico::new);
        return medicoRepository.findAll(paginacion).map(DatosListadoMedico::new);
    }

    @PutMapping
    @Transactional
    public void actualizarMedico(@RequestBody @Valid ActualizarDatosMedico actualizarDatosMedico) {
        Medico medico = medicoRepository.getReferenceById(actualizarDatosMedico.Id());
        medico.actualizarDatos(actualizarDatosMedico);
    }

    //DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarMedico(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.desactivarMedico();
    }

    // DELETE EN BASE DE DATOS
    //  public void eliminarMedico(@PathVariable Long id){
    //     Medico medico = medicoRepository.getReferenceById(id);
    //     medicoRepository.delete(medico);
//}
}
