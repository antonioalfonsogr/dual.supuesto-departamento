package supuesto.aagonzalez.departamentos.domain.repository;

import supuesto.aagonzalez.departamentos.domain.Linea;

import java.util.List;
import java.util.Optional;

public interface LineaRepository {

    List<Linea> obtenerLineas(Long idDepartamento);

    Optional<Linea> obtenerLinea(Long idLinea);

    Linea insertarLinea(Long idDepartamento, Linea linea);

    void actualizarLinea(Long idLinea, Linea linea);

    void eliminarLinea(Long idLinea);


}
