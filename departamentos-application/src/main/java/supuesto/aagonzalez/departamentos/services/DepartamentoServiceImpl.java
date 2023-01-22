package supuesto.aagonzalez.departamentos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import supuesto.aagonzalez.departamentos.domain.Departamento;
import supuesto.aagonzalez.departamentos.domain.repository.DepartamentoRepository;
import supuesto.aagonzalez.departamentos.domain.service.DepartamentoService;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    @Autowired
    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public Departamento insertarDepartamento(Departamento departamento) {
        return this.departamentoRepository.insertarDepartamento(departamento);
    }

    @Override
    public List<Departamento> obtenerDepartamentos() {
        return this.departamentoRepository.obtenerDepartamentos();
    }

    @Override
    public Departamento obtenerDepartamento(Long idDepartamento) {
        return this.departamentoRepository.obtenerDepartamento(idDepartamento).get();
    }

    @Override
    public void actualizarDepartamento(Long idDepartamento, Departamento departamento) {
        this.departamentoRepository.actualizarDepartamento(idDepartamento, departamento);
    }

    @Override
    public void eliminarDepartamento(Long idDepartamento) {
        this.departamentoRepository.eliminarDepartamento(idDepartamento);
    }
}
