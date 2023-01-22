package supuesto.aagonzalez.departamentos.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "departamento")
@EqualsAndHashCode()
public class DepartamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", unique = true, nullable = false)
    private Long idDepartamento;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "director")
    private Long director;

    @OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY, targetEntity = LineaEntity.class)
    private List<LineaEntity> Lineas;
}
