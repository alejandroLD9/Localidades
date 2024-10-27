package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Municipio implements Serializable {
    private String nombre;
    private List<Localidad> localidades;

    public Municipio(String nombre) {
        this.nombre = nombre;
        this.localidades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarLocalidad(Localidad localidad) {
        localidades.add(localidad);
    }

    public List<Localidad> getLocalidades() {
        return localidades;
    }

    @Override
    public String toString() {
        return String.format("Municipio [Nombre: %s, Localidades: %s]", nombre, localidades);
    }
}
