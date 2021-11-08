
package Formulario;

/**
 *@Autores CARLOS ANDRES CONEO DIAZ
 *          ANDRES FABIAN BURGOS DE LAS SALAS 
 *          JAVIER ANDRES HERRERA MANJARREZ
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class FinFormulario extends JPanel{

    public FinFormulario() {
        setLayout(null);
        setBounds(0,0,900,500);
        setBackground(new Color(242,234,191));
    }
    
    public JPanel Intefsss(){
        
        JLabel mejExito = new JLabel("Censo Finalizado",SwingConstants.CENTER);
        mejExito.setBounds(100,150,700,90);
        mejExito.setFont(new Font("wide latin",3,40));
        add(mejExito);
        
        
        JButton btnRegreso =new JButton("Menú");
        btnRegreso.setBounds(200,290,90,30);
        btnRegreso.setFont(new Font("CAlibri",2,16));
        add(btnRegreso);
        
        JLabel imagen= new JLabel();
        imagen.setIcon(new ImageIcon(getClass().getResource("/imagenes/comprobacion.png")));
        imagen.setBounds(386,240,128,128);
        add(imagen);
        
        
        btnRegreso.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Principal prin =new Principal();
                
                removeAll();
                updateUI();
                
                add(prin.Componente());
                
            }
        });
        
        
        return this;
    }
}
