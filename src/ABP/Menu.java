
package ABP;

/**
 *@Autores CARLOS ANDRES CONEO DIAZ
 *          ANDRES FABIAN BURGOS DE LAS SALAS 
 *          JAVIER ANDRES HERRERA MANJARREZ
 */
import java.awt.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.*;

import Formulario.Principal;
import java.io.File;
import java.io.IOException;
import Formulario.VeriFicacion;
import javax.swing.UIManager.LookAndFeelInfo;

public class Menu extends JFrame{
    
    public Menu(){
        //setLayout(new GridLayout(1,1));  
        
        Principal panel = new Principal();
        add(panel.Componente());
        
        Image imagen = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/censo.png"));
        setIconImage(imagen);
    }
    
     public static void main(String args[]){
        try {
	   //Mirar y sentir información           obtener instalado Look And Feels
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                // UIManager = Administrador de interfaz de usuario
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                /*
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                *//*
                if ("Metal".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                */
            }
        } catch (InstantiationException tte) {
            // Si Nimbus no está disponible, puede configurar la interfaz gráfica de usuario con otro aspecto.
        } catch (ClassNotFoundException ex) {
            
        } catch (IllegalAccessException ex) {
            
        } catch (UnsupportedLookAndFeelException ex) {
            
        }
         
         
        Menu ventana = new Menu();
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.setSize(900,500);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Registro ciudadano");
        ventana.setVisible(true);
        
        File buaArchivo = new File("Usuarios.txt");
        
        if(!buaArchivo.exists()){
            try{
                buaArchivo.createNewFile();
            }catch(IOException ee){
                
            }
            
        }
        int perra = 1;
        VeriFicacion ver = new VeriFicacion();
        ver.ordenarDatos(perra);
    }
   
}
