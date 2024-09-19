import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class dataHandler{
    private Scanner r_archivo;
    private DataOutputStream w_archivo;
    private String rutaData;
    private String nombreArchivo;
    public ArrayList<notaGui> notas;

    public dataHandler(){
        nombreArchivo = "notas.csv";
        rutaData = "src/data/"+nombreArchivo;

        notas = leerNotas();
    }

    // READ
    public ArrayList<notaGui> leerNotas(){
        notas = new ArrayList<>();

        try {
            String[] linea;
            r_archivo = new Scanner(new BufferedReader(new FileReader(rutaData)));

            while(r_archivo.hasNextLine()){
                linea = r_archivo.nextLine().split(",");

                if(!linea[0].equals("Fecha")){
                    String fecha = linea[0];
                    String hora = linea[1].trim();
                    String titulo = linea[2].trim();
                    String descripcion = linea[3].trim();

                    notas.add(new notaGui(fecha, hora, titulo, descripcion));
                }
            }

            r_archivo.close();
            return notas;
        } 
        catch (Exception e) {
            System.out.println("Error al leer notas: "+e);
            return null;
        }
    }

    // CREATE
    public void agregarNota(String fecha, String hora, String titulo, String descripcion){

        notas.add(new notaGui(fecha, hora, titulo, descripcion));

        escribirNotas();
    }

    // DELETE
    public void eliminarNota(int pos){
        notas.remove(pos);
        escribirNotas();
    }

    // UPDATE
    public void editarNota(int pos, String dato, String nota){
        notaGui notaEditar = notas.get(pos);

        switch (dato) {
            case "Titulo":
                notaEditar.setTitulo(nota);
                escribirNotas();
                break;

            case "Descripcion":
                notaEditar.setDescripcion(nota);
                escribirNotas();
                break;

            default:
                System.out.println("Dato invalido");
        }
    }

    private void escribirNotas(){
        try {
            w_archivo = new DataOutputStream( new FileOutputStream(rutaData));
            r_archivo = new Scanner(new BufferedReader(new FileReader(rutaData)));

            w_archivo.write("Fecha, Hora, Titulo, Descripcion, caracteres".getBytes());
            for(notaGui i: notas){
                String linea = "\n"+i.toString();
                w_archivo.write(linea.getBytes());
            }
            
            w_archivo.close();
            r_archivo.close();
        } 
        catch (Exception e) {
            
        }
    }
}