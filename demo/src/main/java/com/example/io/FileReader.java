package com.example.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Clase utilitaria para la lectura de archivos de texto.
 * 
 * @author Sergio López
 * @author Cristopher Serrano
 */
public class FileReader {

    /**
     * Constructor por defecto.
     */
    public FileReader() {
        // Constructor vacío
    }

    /**
     * Lee todas las líneas de un archivo y las devuelve en una lista.
     * Ignora las líneas vacías.
     * 
     * @param filePath Ruta del archivo a leer.
     * @return Lista de Strings con el contenido de las líneas.
     * @throws IOException Si hay error al abrir o leer el archivo.
     */
    public List<String> readLines(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            lines = stream
                    .filter(line -> !line.trim().isEmpty())
                    .collect(Collectors.toList());
        }
        return lines;
    }
}