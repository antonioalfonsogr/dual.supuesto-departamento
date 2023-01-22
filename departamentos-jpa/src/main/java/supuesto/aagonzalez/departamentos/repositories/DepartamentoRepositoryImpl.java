package supuesto.aagonzalez.departamentos.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import supuesto.aagonzalez.departamentos.domain.Departamento;
import supuesto.aagonzalez.departamentos.domain.repository.DepartamentoRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class DepartamentoRepositoryImpl implements DepartamentoRepository {

    private final DepartamentoCrudRepository departamentoCrudRepository;
    private final Converter converter;

    @Autowired
    public DepartamentoRepositoryImpl(DepartamentoCrudRepository departamentoCrudRepository, Converter converter) {
        this.departamentoCrudRepository = departamentoCrudRepository;
        this.converter = converter;
    }

    @Override
    public List<Departamento> obtenerDepartamentos() {
        return this.converter.toDepartamentos((List<DepartamentoEntity>) this.departamentoCrudRepository.findAll());
    }

    @Override
    public Optional<Departamento> obtenerDepartamento(Long idDepartamento) {
        DepartamentoEntity departamentoEntity = this.departamentoCrudRepository.findById(idDepartamento).orElseThrow();
        return Optional.of(this.converter.toDepartamento(departamentoEntity));
    }

    @Override
    public Departamento insertarDepartamento(Departamento departamento) {
        DepartamentoEntity departamentoEntity = this.converter.toDepartamentoEntity(departamento);
        return this.converter.toDepartamento(this.departamentoCrudRepository.save(departamentoEntity));
    }

    @Override
    public void actualizarDepartamento(Long idDepartamento, Departamento departamento) {
        DepartamentoEntity departamentoEntity = this.departamentoCrudRepository.findById(idDepartamento).orElseThrow();
        departamentoEntity.setDescripcion(departamento.getDescripcion());
        departamentoEntity.setDirector(departamento.getDirector());
        this.converter.toDepartamento(this.departamentoCrudRepository.save(departamentoEntity));
    }

    @Override
    public void eliminarDepartamento(Long idDepartamento) {
        DepartamentoEntity departamentoEntity = this.departamentoCrudRepository.findById(idDepartamento).orElseThrow();
        this.departamentoCrudRepository.deleteById(departamentoEntity.getIdDepartamento());
    }

}
