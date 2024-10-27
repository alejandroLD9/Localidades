package aplicacion;

import dominio.Localidad;
import dominio.Municipio;
import dominio.Provincia;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private static List<Provincia> provincias = new ArrayList<>();
    private static final String FILE_NAME = "datos.ser";

    public static void main(String[] args) {
        cargarDatos();
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print("Ingrese una instrucción: ");
            input = scanner.nextLine();

            if (input.equals("exit")) {
                guardarDatos();
                System.out.println("Programa finalizado.");
                break;
            } else if (input.equals("leer")) {
                cargarDatos();
            } else if (input.equals("add provincia")) {
                System.out.print("Nombre de la provincia: ");
                String nombre = scanner.nextLine();
                provincias.add(new Provincia(nombre));
            } else if (input.equals("add municipio")) {
                System.out.print("Nombre de la provincia: ");
                String nombreProvincia = scanner.nextLine();
                Provincia provincia = buscarProvincia(nombreProvincia);

                if (provincia != null) {
                    System.out.print("Nombre del municipio: ");
                    String nombreMunicipio = scanner.nextLine();
                    provincia.agregarMunicipio(new Municipio(nombreMunicipio));
                } else {
                    System.out.println("Provincia no encontrada.");
                }
            } else if (input.equals("add localidad")) {
                System.out.print("Nombre de la provincia: ");
                String nombreProvincia = scanner.nextLine();
                Provincia provincia = buscarProvincia(nombreProvincia);

                if (provincia != null) {
                    System.out.print("Nombre del municipio: ");
                    String nombreMunicipio = scanner.nextLine();
                    Municipio municipio = buscarMunicipio(provincia, nombreMunicipio);

                    if (municipio != null) {
                        System.out.print("Nombre de la localidad: ");
                        String nombreLocalidad = scanner.nextLine();
                        System.out.print("Número de habitantes: ");
                        int habitantes = Integer.parseInt(scanner.nextLine());
                        municipio.agregarLocalidad(new Localidad(nombreLocalidad, habitantes));
                    } else {
                        System.out.println("Municipio no encontrado.");
                    }
                } else {
                    System.out.println("Provincia no encontrada.");
                }
            } else if (input.equals("list")) {
                listarDatos();
            } else {
                System.out.println("Instrucción no reconocida.");
            }
        }
    }

    // Buscar provincia por nombre
    private static Provincia buscarProvincia(String nombre) {
        for (Provincia provincia : provincias) {
            if (provincia.getNombre().equalsIgnoreCase(nombre)) {
                return provincia;
            }
        }
        return null;
    }

    // Buscar municipio por nombre dentro de una provincia
    private static Municipio buscarMunicipio(Provincia provincia, String nombre) {
        for (Municipio municipio : provincia.getMunicipios()) {
            if (municipio.getNombre().equalsIgnoreCase(nombre)) {
                return municipio;
            }
        }
        return null;
    }

    // Listar todos los datos
    private static void listarDatos() {
        for (Provincia provincia : provincias) {
            System.out.println(provincia);
        }
    }

    // Guardar datos en archivo
    private static void guardarDatos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(provincias);
            System.out.println("Datos guardados exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    // Cargar datos desde archivo
    private static void cargarDatos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            provincias = (List<Provincia>) ois.readObject();
            System.out.println("Datos cargados exitosamente.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de datos no encontrado. Iniciando sin datos previos.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }
}
