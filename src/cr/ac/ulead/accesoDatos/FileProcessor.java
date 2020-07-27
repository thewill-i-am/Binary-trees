package cr.ac.ulead.accesoDatos;

import cr.ac.ulead.modelos.Persona;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public abstract class FileProcessor {
    protected String fileName;

    public FileProcessor(String fileName) {
        this.fileName = fileName;
    }

    public List<Persona> processFile() throws FileNotFoundException {
        Scanner reader = openFile();
        List<Persona> result = readLines(reader);
        reader.close();
        return result;
    }

    protected Scanner openFile() throws FileNotFoundException {
        return new Scanner(new File(fileName));
    }

    protected abstract List<Persona> readLines(Scanner reader);
}