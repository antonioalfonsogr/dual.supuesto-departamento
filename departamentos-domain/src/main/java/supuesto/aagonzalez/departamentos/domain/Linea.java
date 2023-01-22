package supuesto.aagonzalez.departamentos.domain;

import lombok.Data;

@Data
public class Linea {

    private Long idLinea;

    private String descripcion;

    private Long responsable;

    private Departamento departamento;

}
