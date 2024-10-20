package aplicacion;

import dominio.Localidad;
import dominio.Municipio;
import dominio.Provincia;

public class Principal {
    public static void main(String[] args) {
        Localidad loc1 = new Localidad("Localidad A");
        Localidad loc2 = new Localidad("Localidad B");

        Municipio municipio = new Municipio("Municipio 1");
        municipio.agregarLocalidad(loc1);
        municipio.agregarLocalidad(loc2);

        Provincia provincia = new Provincia("Provincia 1");
        provincia.agregarMunicipio(municipio);

        System.out.println(provincia);

        int totalHabitantes = provincia.contarHabitantes();
        System.out.println("Total de habitantes en la " + provincia.getNombre() + ": " + totalHabitantes);
    }
}