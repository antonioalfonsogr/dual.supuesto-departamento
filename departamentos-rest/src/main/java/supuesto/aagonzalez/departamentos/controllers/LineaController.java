package supuesto.aagonzalez.departamentos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import supuesto.aagonzalez.departamentos.domain.Linea;
import supuesto.aagonzalez.departamentos.domain.service.DepartamentoService;
import supuesto.aagonzalez.departamentos.domain.service.LineaService;


import java.util.List;

@RestController
@RequestMapping("/departamentos/{idDepartamento}/lineas")
public class LineaController {

    private final LineaService lineaService;
    private final DepartamentoService departamentoService;

    @Autowired
    public LineaController(LineaService lineaService, DepartamentoService departamentoService) {
        this.lineaService = lineaService;
        this.departamentoService = departamentoService;
    }

    @GetMapping(value = "")
    public List<Linea> obtenerLineas(@PathVariable(name = "idDepartamento") Long idDepartamento) {
        return departamentoService.obtenerDepartamento(idDepartamento).getLineas();
    }

    @PostMapping(value = "")
    public Linea insertarLinea(@PathVariable(name = "idDepartamento") Long idDepartamento, @RequestBody Linea linea) {
        return this.lineaService.insertarLinea(idDepartamento, linea);
    }

    @GetMapping(value = "/{id}")
    public Linea obtenerLinea(@PathVariable(name = "id") String id) {
        return this.lineaService.obtenerLinea(Long.valueOf(id));
    }

    @PutMapping(value = "/{id}")
    public void actualizarLinea(@PathVariable(name = "id") Long id, @RequestBody Linea linea) {
        this.lineaService.actualizarLinea(id, linea);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminarLinea(@PathVariable(name = "id") Long id) {
        this.lineaService.eliminarLinea(id);
    }

}
