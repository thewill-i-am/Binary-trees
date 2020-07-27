package cr.ac.ulead.ui;

import cr.ac.ulead.modelos.Persona;
import cr.ac.ulead.parseadorUtil.DateParser;

import java.util.Scanner;

public class GestorGrafico {
    private Scanner entradaEscaner = new Scanner (System.in);
    DateParser date;

    public GestorGrafico(){
        this.date = new DateParser();
    }

    public Boolean solicitarDatos(){
        System.out.println("Escriba true para cargar los datos del CSV y false para cargarlos manualmente");
        return entradaEscaner.nextBoolean();
    }

    public Persona solicitarDatos(Persona persona){
        System.out.println("Por favor ingrese el nombre");
        persona.setNombre(entradaEscaner.next());
        System.out.println("Por favor ingrese el apellido");
        persona.setApellido(entradaEscaner.next());
        persona.setFechaNacimiento(this.date.parseador(valoresFecha()));
        System.out.println("Por favor ingrese la cedula");
        persona.setCedula(entradaEscaner.next());
        System.out.println("Persona Llena");
        return persona;
    }

    private String obtenerMesValido(){
        String[] mesesAnio = {"ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO"
                ,"SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
        for (int i = 0; i < mesesAnio.length ; i++) {
            System.out.print(i + " <- ");
            System.out.print(mesesAnio[i]);
            System.out.println();
        }
        System.out.println("Ingrese el index del mes que quiere :");
        Integer indexMes = entradaEscaner.nextInt();
        if (indexMes > 11) {
            obtenerMesValido();
        }
        if (Integer.toString(indexMes).length() == 1){
            return "0" + indexMes;
        }
        return Integer.toString(indexMes);
    }

    private String obtenerDiaValido(){
        System.out.println("Ingrese un dia de la semana valido");
        String indexDia = entradaEscaner.next();
        if (indexDia.length() == 1){
            indexDia = "0" + indexDia;
        }
        return indexDia;
    }

    private String valoresFecha (){
        System.out.println("Ingrese el anio :");
        Integer anio = entradaEscaner.nextInt();
        return anio + "-" + obtenerMesValido() + "-" + obtenerDiaValido();
    }
}
