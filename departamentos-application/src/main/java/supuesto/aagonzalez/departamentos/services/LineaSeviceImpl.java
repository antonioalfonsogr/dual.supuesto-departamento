package supuesto.aagonzalez.departamentos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import supuesto.aagonzalez.departamentos.domain.Linea;
import supuesto.aagonzalez.departamentos.domain.repository.LineaRepository;
import supuesto.aagonzalez.departamentos.domain.service.LineaService;

import java.util.List;

@Service
public class LineaSeviceImpl implements LineaService {

    private final LineaRepository lineaRepository;

    @Autowired

    public LineaSeviceImpl(LineaRepository lineaRepository) {
        this.lineaRepository = lineaRepository;
    }

    @Override
    public Linea insertarLinea(Long idDepartamento, Linea linea) {
        return this.lineaRepository.insertarLinea(idDepartamento, linea);
    }

    @Override
    public List<Linea> obtenerLineas(Long idDepartamento) {
        return this.lineaRepository.obtenerLineas(idDepartamento);
    }

    @Override
    public Linea obtenerLinea(Long idLinea) {
        return this.lineaRepository.obtenerLinea(idLinea).get();
    }

    @Override
    public void actualizarLinea(Long idLinea, Linea linea) {
        this.lineaRepository.actualizarLinea(idLinea, linea);
    }

    @Override
    public void eliminarLinea(Long idLinea) {
        this.lineaRepository.eliminarLinea(idLinea);
    }
}
