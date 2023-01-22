package supuesto.aagonzalez.departamentos.repositories;

import org.springframework.stereotype.Component;
import supuesto.aagonzalez.departamentos.domain.Departamento;
import supuesto.aagonzalez.departamentos.domain.Linea;

import java.util.ArrayList;
import java.util.List;

@Component
public class Converter {

    // DEPARTAMENTOS

    public Departamento toDepartamento(DepartamentoEntity departamentoEntity) {

        Departamento departamento = new Departamento();

        departamento.setIdDepartamento(departamentoEntity.getIdDepartamento());
        departamento.setDescripcion(departamentoEntity.getDescripcion());
        departamento.setDirector(departamentoEntity.getDirector());
        if (departamentoEntity.getLineas() != null) {
            departamento.setLineas(toLineas(departamentoEntity.getLineas()));
        } else {
            departamento.setLineas(new ArrayList<>());
        }
        return departamento;
    }

    public DepartamentoEntity toDepartamentoEntity(Departamento departamento) {

        DepartamentoEntity departamentoEntity = new DepartamentoEntity();

        departamentoEntity.setIdDepartamento(departamento.getIdDepartamento());
        departamentoEntity.setDescripcion(departamento.getDescripcion());
        departamentoEntity.setDirector(departamento.getDirector());
        if (departamento.getLineas() != null) {
            departamentoEntity.setLineas(toLineasEntities(departamento.getLineas()));
        } else {
            departamentoEntity.setLineas(new ArrayList<>());
        }

        return departamentoEntity;
    }

    public List<Departamento> toDepartamentos(List<DepartamentoEntity> all) {
        List<Departamento> departamentoList = new ArrayList<>();
        for (DepartamentoEntity c : all) {
            departamentoList.add(toDepartamento(c));
        }
        return departamentoList;
    }

    public List<DepartamentoEntity> toDepartamentosEntities(List<Departamento> all) {
        List<DepartamentoEntity> departamentoEntityList = new ArrayList<>();
        for (Departamento c : all) {
            departamentoEntityList.add(toDepartamentoEntity(c));
        }
        return departamentoEntityList;
    }

    // LINEAS

    public Linea toLinea(LineaEntity lineaEntity) {

        Linea linea = new Linea();

        linea.setIdLinea(lineaEntity.getIdLinea());
        linea.setDescripcion(lineaEntity.getDescripcion());
        linea.setResponsable(lineaEntity.getResponsable());
        if (linea.getDepartamento() != null) {
            linea.setDepartamento(toDepartamento(lineaEntity.getDepartamento()));
        } else {
            lineaEntity.setDepartamento(new DepartamentoEntity());
        }

        return linea;
    }

    public LineaEntity toLineaEntity(Linea linea) {

        LineaEntity lineaEntity = new LineaEntity();

        lineaEntity.setIdLinea(linea.getIdLinea());
        lineaEntity.setDescripcion(linea.getDescripcion());
        lineaEntity.setResponsable(linea.getResponsable());
        if (linea.getDepartamento() != null) {
            lineaEntity.setDepartamento(toDepartamentoEntity(linea.getDepartamento()));
        } else {
            lineaEntity.setDepartamento(new DepartamentoEntity());
        }

        return lineaEntity;
    }

    public List<Linea> toLineas(List<LineaEntity> all) {
        List<Linea> lineaList = new ArrayList<>();
        for (LineaEntity r : all) {
            lineaList.add(toLinea(r));
        }
        return lineaList;
    }

    public List<LineaEntity> toLineasEntities(List<Linea> all) {
        List<LineaEntity> lineaEntityList = new ArrayList<>();
        for (Linea r : all) {
            lineaEntityList.add(toLineaEntity(r));
        }
        return lineaEntityList;
    }
}
