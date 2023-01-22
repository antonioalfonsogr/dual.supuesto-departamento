package supuesto.aagonzalez.departamentos.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import supuesto.aagonzalez.departamentos.domain.Linea;
import supuesto.aagonzalez.departamentos.domain.repository.LineaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class LineaRepositoryImpl implements LineaRepository {

    private final LineaCrudRepository lineaCrudRepository;
    private final Converter converter;
    private final DepartamentoCrudRepository departamentoCrudRepository;

    @Autowired
    public LineaRepositoryImpl(LineaCrudRepository lineaCrudRepository, Converter converter, DepartamentoCrudRepository departamentoCrudRepository) {
        this.lineaCrudRepository = lineaCrudRepository;
        this.converter = converter;
        this.departamentoCrudRepository = departamentoCrudRepository;
    }

    @Override
    public List<Linea> obtenerLineas(Long idDepartamento) {
        return this.converter.toLineas((List<LineaEntity>) this.lineaCrudRepository.findAll());
    }

    @Override
    public Optional<Linea> obtenerLinea(Long idLinea) {
        LineaEntity lineaEntity = this.lineaCrudRepository.findById(idLinea).orElseThrow();
        return Optional.of(this.converter.toLinea(lineaEntity));
    }

    @Override
    public Linea insertarLinea(Long idDepartamento, Linea linea) {
        LineaEntity lineaEntity = this.converter.toLineaEntity(linea);
        lineaEntity.setDepartamento(departamentoCrudRepository.findById(idDepartamento).orElseThrow());
        return this.converter.toLinea(this.lineaCrudRepository.save(lineaEntity));
    }

    @Override
    public void actualizarLinea(Long idLinea, Linea linea) {
        LineaEntity lineaEntity = this.lineaCrudRepository.findById(idLinea).orElseThrow();
        lineaEntity.setDescripcion(linea.getDescripcion());
        lineaEntity.setResponsable(linea.getResponsable());
        this.lineaCrudRepository.save(lineaEntity);
    }

    @Override
    public void eliminarLinea(Long idLinea) {
        LineaEntity lineaEntity = this.lineaCrudRepository.findById(idLinea).orElseThrow();
        this.lineaCrudRepository.deleteById(lineaEntity.getIdLinea());
    }
}
