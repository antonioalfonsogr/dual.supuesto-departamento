package supuesto.aagonzalez.departamentos.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "linea")
public class LineaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long idLinea;
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "responsable")
    private Long responsable;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = DepartamentoEntity.class)
    @JoinColumn(nullable = false, name = "id_departamento")
    private DepartamentoEntity departamento;


}
