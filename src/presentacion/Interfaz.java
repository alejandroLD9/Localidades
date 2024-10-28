package presentacion;
import dominio.*;
import java.io.*;
import java.util.*;
public class Interfaz {
    private Pais p=new Pais();
    private  Scanner sc = new Scanner(System.in);
    public Interfaz(){
  	//implementar
    }

    public void grabar(){
	//implementar
    }
    public static void ayuda(){
        System.out.println("introduzca ua de las siguientes peticiones: \n addProvindia: añadir provincia\n addMunicipio: añadir Municipio\n addLocalidad: añadir Localidad\n list: listar el contenido\n read: lectura inicial\n exit: salir\n");

    }
    public  boolean procesarPeticion (String [] p){
        if (p.length==1)
            if 	(p[0].equals("addProvincia"))
               aniadirProvincia();
            else if (p[0].equals("addMunicipio"))
               aniadirMunicipio();
            else if (p[0].equals("addLocalidad"))
            aniadirLocalidad();
            else if (p[0].equals("read"))
	            leer();
	        else if (p[0].equals("list"))
                    System.out.println (p);
            else if (p[0].equals("help"))
		    ayuda();
            else if (p[0].equals("exit")){
                    grabar();
                    return false;//no se procesarán más peticiónes
            }
            else {
                    System.out.println("petición erronea");
                    ayuda();
                }
        else {
            System.out.println("petición erronea");
            ayuda();
        }
        return true;//en todos los casos debe seguir pidiendo y procesando peticiones
    }
    public  void aniadirProvincia(){
	//implementar
    }

    public  void aniadirMunicipio(){
	//implementar
    }

    public  void aniadirLocalidad(){
	//implementar
    }
    public String [] leerPeticion(){
        System.out.print("?>");
        String cadena = sc.nextLine();
        return cadena.split(" ");
    }

    public  void leer(){
            String nombreP, nombreM, nombreL;
            do {
            System.out.print("Introduce el nombre de la provincia (<enter> para finalizar: ");
            nombreP=sc.nextLine();
            if(!nombreP.equals("")){
                Provincia provincia=new Provincia(nombreP);
                do {
                    System.out.print("Introduce el nombre del municipio (<enter> para finalizar: ");
                    nombreM=sc.nextLine();
                    if(!nombreM.equals("")){
                        Municipio municipio=new Municipio(nombreM);
                        do {
                            System.out.print("Introduce el nombre de la localidad (<enter> para finalizar: ");
                            nombreL=sc.nextLine();
                            if(!nombreL.equals("")){
                                System.out.print("Introduce la población de la localidad: ");
                                int poblacion=sc.nextInt();
                                sc.nextLine();
                                Localidad localidad=new Localidad(nombreL,poblacion);
                                municipio.add(localidad);
                            }
                        } while (!nombreL.equals(""));
                        provincia.add(municipio);
                    }
                } while (!nombreM.equals(""));
                p.add(provincia);
            }
    }
    while (!nombreP.equals(""));

    }

}
