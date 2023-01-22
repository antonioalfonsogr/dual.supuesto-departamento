package supuesto.aagonzalez.departamentos.domain;

import lombok.Data;

import java.util.List;

@Data
public class Departamento {

    private Long idDepartamento;

    private String descripcion;

    private Long director;

    private List<Linea> Lineas;

}
 