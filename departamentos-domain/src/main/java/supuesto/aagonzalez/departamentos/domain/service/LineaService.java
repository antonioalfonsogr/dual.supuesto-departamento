package supuesto.aagonzalez.departamentos.domain.service;

import supuesto.aagonzalez.departamentos.domain.Linea;

import java.util.List;

public interface LineaService {

    Linea insertarLinea(Long idDepartamento, Linea linea);

    List<Linea> obtenerLineas(Long idDepartamento);

    Linea obtenerLinea(Long idLinea);

    void actualizarLinea(Long idLinea, Linea linea);

    void eliminarLinea(Long idLinea);
}
