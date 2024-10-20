package dominio;

import java.util.ArrayList;
import java.util.List;

public class Provincia {
        private String nombre;
        private List<Municipio> municipios;

        public Provincia(String nombre) {
            this.nombre = nombre;
            this.municipios = new ArrayList<>();
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public List<Municipio> getMunicipios() {
            return municipios;
        }

        public void agregarMunicipio(Municipio municipio) {
            municipios.add(municipio);
        }

        public int contarHabitantes() {
            int totalHabitantes = 0;
            for (Municipio municipio : municipios) {
                totalHabitantes += municipio.contarHabitantes();
            }
            return totalHabitantes;
        }
    public String toString() {
        return "Provincia [Nombre: " + nombre + ", Municipios: " + municipios + "]";
    }
}
