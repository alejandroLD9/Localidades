package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Provincia implements Serializable {
    private String nombre;
    private List<Municipio> municipios;

    public Provincia(String nombre) {
        this.nombre = nombre;
        this.municipios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarMunicipio(Municipio municipio) {
        municipios.add(municipio);
    }

    public List<Municipio> getMunicipios() {
        return municipios;
    }

    @Override
    public String toString() {
        return String.format("Provincia [Nombre: %s, Municipios: %s]", nombre, municipios);
    }
}
