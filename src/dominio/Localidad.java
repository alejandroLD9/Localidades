package dominio;

import java.io.Serializable;

public class Localidad implements Serializable {
    private String nombre;
    private int numeroDeHabitantes;

    public Localidad(String nombre, int numeroDeHabitantes) {
        this.nombre = nombre;
        this.numeroDeHabitantes = numeroDeHabitantes;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroDeHabitantes() {
        return numeroDeHabitantes;
    }

    @Override
    public String toString() {
        return String.format("Localidad [Nombre: %s, Habitantes: %d]", nombre, numeroDeHabitantes);
    }
}

