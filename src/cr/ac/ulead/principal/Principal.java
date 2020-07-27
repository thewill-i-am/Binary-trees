package cr.ac.ulead.principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import cr.ac.ulead.Node;
import cr.ac.ulead.Tree;
import cr.ac.ulead.accesoDatos.ProcesadorPersona;
import cr.ac.ulead.modelos.Persona;
import cr.ac.ulead.ui.GestorGrafico;

public class Principal {

    public static void main(String[] args) throws IOException {
        int value;
        Tree theTree = new Tree();
        GestorGrafico ui = new GestorGrafico();
        boolean datosCargados = false;

        while (true) {
            System.out.print("Ingrese la primera letra de la accion, ");
            System.out.print("insertar, desplegar, o transaversar(recorridos pre-order - in-order - post-order): ");
            int option = getChar();
            switch (option) {
                case 'i':
                    if (ui.solicitarDatos()) {
                        if (!datosCargados) {
                            ProcesadorPersona procesadorPersona =
                                    new ProcesadorPersona
                                            ("src/cr/ac/ulead/datos/csv.csv");
                            List<Persona> listaPersonas = procesadorPersona.processFile();
                            for (Persona persona : listaPersonas) {
                                theTree.insert(persona);
                            }
                            datosCargados = true;
                        } else {
                            System.out.println("Los datos ya estaban cargados");
                        }
                    } else {
                        Persona persona = new Persona();
                        theTree.insert(ui.solicitarDatos(persona));
                    }
                    break;
                case 't':
                    System.out.print("Ingrese 1 -> (pre-order), 2 -> (in-order) o 3 -> (post-order): ");
                    value = getInt();
                    theTree.traverse(value);
                    break;
                case 'd':
                    theTree.displayTree();
                    break;
                case 's':
                    System.out.println("Gracias por usar el sistema !");
                    return;
                default:
                    System.out.print("Invalid entry\n");
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
