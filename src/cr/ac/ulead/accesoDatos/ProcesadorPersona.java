package cr.ac.ulead.accesoDatos;

import cr.ac.ulead.modelos.Persona;
import cr.ac.ulead.parseadorUtil.DateParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcesadorPersona extends FileProcessor {
    private DateParser dateParser;

    public ProcesadorPersona(String fileName) {
        super(fileName);
        this.dateParser = new DateParser();
    }

    @Override
    protected List<Persona> readLines(Scanner reader) {
        ArrayList<Persona> result = new ArrayList<>();
        boolean skip = true;
        while (reader.hasNextLine()) {
            String onePersona = reader.nextLine();
            if (!skip) {
                Persona currentPersona = getPersonaFromString(onePersona);
                result.add(currentPersona);
            } else {
                skip = false;
            }
        }
        return result;
    }

    private Persona getPersonaFromString(String personaData) {
        Persona nuevaPersona = new Persona();
        String[] data = personaData.split(",");
        nuevaPersona.setNombre(data[0]);
        nuevaPersona.setApellido(data[1]);
        nuevaPersona.setFechaNacimiento(this.dateParser.parseador(data[2] + "-" + data[3] + "-" + data[4]));
        nuevaPersona.setCedula(data[5]);;
        return nuevaPersona;
    }
}
