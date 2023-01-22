package supuesto.aagonzalez.departamentos.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import supuesto.aagonzalez.departamentos.domain.Departamento;
import supuesto.aagonzalez.departamentos.domain.service.DepartamentoService;

import java.util.List;

@RestController
@RequestMapping("departamentos")
public class DepartamentoController {

    private final DepartamentoService clienteService;

    @Autowired
    public DepartamentoController(DepartamentoService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(value = "")
    public List<Departamento> obtenerClientes() {
        return clienteService.obtenerDepartamentos();
    }

    @PostMapping(value = "")
    public Departamento insertarCliente(@RequestBody Departamento cliente) {
        return this.clienteService.insertarDepartamento(cliente);
    }

    @GetMapping(value = "/{id}")
    public Departamento obtenerCliente(@PathVariable Long id) {
        return this.clienteService.obtenerDepartamento(id);
    }

    @PutMapping(value = "/{id}")
    public void actualizarCliente(@PathVariable Long id, @RequestBody Departamento cliente) {
        this.clienteService.actualizarDepartamento(id, cliente);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        this.clienteService.eliminarDepartamento(id);
    }
}
