
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
        
        JPopupMenu meEmergente = new JPopupMenu();
        JSeparator nu1 = new JSeparator();
        JSeparator nu2 = new JSeparator();
        JSeparator nu3 = new JSeparator();
                        
        JMenuItem btnMenus = new JMenuItem("Menú");
        btnMenus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                removeAll();
                updateUI();

                Principal prin = new Principal();

                add(prin.Componente());
                meEmergente.removeAll();
            }
            
        });
        JMenuItem btnTAbla = new JMenuItem("Tabla de registrados");
        btnTAbla.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                removeAll();
                updateUI();
                DatosPersona dar = new DatosPersona();
                add(dar.componentes());
                meEmergente.removeAll();
            }
            
        });
        JMenuItem btnbuscar = new JMenuItem("Buscar persona");
        btnbuscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                removeAll();
                updateUI();
                
                BuscarPersona eee =new BuscarPersona();
                add(eee.conponentes());
                meEmergente.removeAll();
            }
            
        });
        
        JMenuItem eliminarPerso = new JMenuItem("Eliminar persona");
        eliminarPerso.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                removeAll();
                updateUI();
                
                EliminarPersona prin = new EliminarPersona();

                add(prin.conponente());
                
                meEmergente.removeAll();
            }
            
        });
                    
        meEmergente.add(btnMenus);
        meEmergente.add(nu1);
        meEmergente.add(btnTAbla);
        meEmergente.add(nu2);
        meEmergente.add(btnbuscar);
        meEmergente.add(nu3);
        meEmergente.add(eliminarPerso);

        setComponentPopupMenu(meEmergente);

        return this;
    }
}
