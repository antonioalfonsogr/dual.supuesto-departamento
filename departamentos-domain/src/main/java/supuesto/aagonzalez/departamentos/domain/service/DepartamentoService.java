package supuesto.aagonzalez.departamentos.domain.service;

import supuesto.aagonzalez.departamentos.domain.Departamento;

import java.util.List;

public interface DepartamentoService {

    Departamento insertarDepartamento(Departamento departamento);

    List<Departamento> obtenerDepartamentos();

    Departamento obtenerDepartamento(Long idDepartamento);

    void actualizarDepartamento(Long idDepartamento, Departamento departamento);

    void eliminarDepartamento(Long idDepartamento);
}
