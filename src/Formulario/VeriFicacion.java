
package Formulario;

/**
 *@Autores CARLOS ANDRES CONEO DIAZ
 *          ANDRES FABIAN BURGOS DE LAS SALAS 
 *          JAVIER ANDRES HERRERA MANJARREZ
 */
import java.io.*;
import java.util.ArrayList;
public class VeriFicacion {
    
    ArrayList<String> ArrNombre = new ArrayList<>(); //1
    ArrayList<String> ArrApellidos = new ArrayList<>(); //2
    ArrayList<String> ArrSexo = new ArrayList<>();  // 3
    ArrayList<String> ArrFeNacimiento = new ArrayList<>();  //4
    ArrayList<String> ArrEstudios = new ArrayList<>();  // 5
    ArrayList<String> ArrAltura = new ArrayList<>();  // 6
    ArrayList<String> ArrEdad = new ArrayList<>();  // 7
    ArrayList<String> ArrEstMilitar = new ArrayList<>();  // 8
    ArrayList<String> ArrIDN = new ArrayList<>();  // 9
    ArrayList<String> ArrFechCenso = new ArrayList<>();  // 10
    ArrayList<String> ArrDepaYPoblacion = new ArrayList<>();  // 11
    ArrayList<String> ArrCalleYNcasa = new ArrayList<>();  // 12
    
    File archivo;
    FileReader leer;
    BufferedReader almacenamiento;
    
    
    public VeriFicacion() {
    
    }
    
    public boolean verificarSiEsta(String nom, String apellidos, String sexo, String fechaNaCi){
        /////     llenando los ArrayList
        int lon=0;
        String cadena = "";
        archivo = new File("Usuarios.txt");
        try {
            leer = new FileReader(archivo);
            // abrir el archivo que se le estraeran los datos
            almacenamiento = new BufferedReader(leer);
            //     Para obtener las lineas de testo de archivo
            while (cadena != null) {
                try {
                    cadena = almacenamiento.readLine();
                    ArrNombre.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrApellidos.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrSexo.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrFeNacimiento.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrEstudios.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrAltura.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrEdad.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrEstMilitar.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrIDN.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrFechCenso.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrDepaYPoblacion.add(lon, cadena);

                    cadena = almacenamiento.readLine();
                    ArrCalleYNcasa.add(lon, cadena);

                    lon++;
                } catch (IOException ee) {

                }
            }
            try {
                //   cerrando bufer
                almacenamiento.close();
            } catch (IOException er) {

            }
            try {
                //   serrando archivo
                leer.close();
            } catch (IOException er) {

            }

        } catch (FileNotFoundException rr) {

        }
        
        boolean resultado = false;
        
        for (int y = 0; y < ArrNombre.size() - 1; y++) {
            if (ArrNombre.get(y).equalsIgnoreCase(nom) && ArrApellidos.get(y).equalsIgnoreCase(apellidos) && ArrSexo.get(y).equalsIgnoreCase(sexo) && ArrFeNacimiento.get(y).equals(fechaNaCi)) {
                resultado=true;
                break;
            }

        }

        return resultado;
    }/// fin del metodo verificacion
    
    
}///   fin de la clase
