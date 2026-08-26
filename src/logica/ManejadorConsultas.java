package logica;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ManejadorDiasConsulta {

    private Map<String, Dia_consulta> diasConsulta;
    private static ManejadorDiasConsulta instancia = null;

    private ManejadorDiasConsulta() {
        diasConsulta = new HashMap<String, Dia_consulta>();
    }

    public static ManejadorDiasConsulta getinstance() {
        if (instancia == null)
            instancia = new ManejadorDiasConsulta();
        return instancia;
    }

    public void addDiaConsulta(Dia_consulta dc) {
        diasConsulta.put(dc.getNombre(), dc);
    }

    public boolean existeDiaConsulta(String nombre) {
        return diasConsulta.get(nombre) != null;
    }

    public Dia_consulta getDiaConsulta(String nombre) {
        return diasConsulta.get(nombre);
    }

    public Set<Dia_consulta> getTodosDiasConsulta() {
        return new HashSet<Dia_consulta>(diasConsulta.values());
    }
}