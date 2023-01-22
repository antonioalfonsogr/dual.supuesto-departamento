package supuesto.aagonzalez.departamentos.domain.repository;

import supuesto.aagonzalez.departamentos.domain.Departamento;

import java.util.List;
import java.util.Optional;

public interface DepartamentoRepository {

    List<Departamento> obtenerDepartamentos();

    Optional<Departamento> obtenerDepartamento(Long idDepartamento);

    Departamento insertarDepartamento(Departamento departamento);

    void actualizarDepartamento(Long idDepartamento, Departamento departamento);

    void eliminarDepartamento(Long idDepartamento);

}
