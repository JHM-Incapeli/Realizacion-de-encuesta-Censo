
package Formulario;
/**
 *@Autores CARLOS ANDRES CONEO DIAZ
 *          ANDRES FABIAN BURGOS DE LAS SALAS 
 *          JAVIER ANDRES HERRERA MANJARREZ
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Principal extends JPanel{
    public Principal() {
        setLayout(null);
        setBounds(0,0,900,500);
        //setOpaque(false);
        setBackground(new Color(213,233,253)); 
        
    }
    Registro regis = new Registro();
    DatosPersona tabla = new DatosPersona();
    public JPanel Componente() {
        JPopupMenu meEmergente = new JPopupMenu();
        /*
        La imagen de Java la alojaremos en un JLabel usando 
        para esto el método setIcon en el cual instanciaremos
        un objeto de tipo ImageIcon que buscaremos dentro del proyecto en la ruta definida
        */
        
        JLabel imagen= new JLabel();
        imagen.setIcon(new ImageIcon(getClass().getResource("/imagenes/edificio-del-gobierno.png")));
        imagen.setBounds(752,10,128,128);
        imagen.setBorder(BorderFactory.createLineBorder(Color.yellow));
        add(imagen);
        
        JLabel image= new JLabel();
        image.setIcon(new ImageIcon(getClass().getResource("/imagenes/censoDeJFrame.png")));
        image.setBounds(20,310,128,128);
        add(image);
        
        JLabel juntoanicio = new JLabel("Bienvenido");
        juntoanicio.setFont(new Font("Bahnschrift",3,60));
        juntoanicio.setHorizontalAlignment(SwingConstants.CENTER);
        juntoanicio.setBounds(20,100, 840, 60);
        add(juntoanicio);
        
        
        JLabel descripccion = new JLabel("Esta es la app para realizar el censo nacional ");
        descripccion.setFont(new Font("calibri",2,30));
        descripccion.setHorizontalAlignment(SwingConstants.CENTER);
        descripccion.setBounds(20,161, 840, 30);
        add(descripccion);
        
        
        JLabel description2 = new JLabel("  -Presione el botón registrarse para realizar el formulario  ");
        description2.setFont(new Font("calibri",2,30));
        description2.setBounds(20,192, 840, 30);
        add(description2);
        
        JLabel descrition3 = new JLabel("  -Presione el botón salir para cerrar el programa ");
        descrition3.setFont(new Font("calibri",2,30));
        descrition3.setBounds(20,223, 840, 30);
        add(descrition3);
        
        
        ///                boton Registrarce
        JButton boRegistrarte =new JButton("Registrarse");
        boRegistrarte.setBounds(200,290,110,30);
        boRegistrarte.setFont(new Font("calibri",2,16));
        add(boRegistrarte);
        
        ////             boton Salir
        JButton boSalir = new JButton("Salir");
        boSalir.setBounds(590,290,110,30);
        boSalir.setForeground(Color.BLACK);
        boSalir.setFont(new Font("calibri",2,16));
        boSalir.setBackground(new Color(223,9,14));
        add(boSalir);
        
        
        JButton registros = new JButton("Archivos");
        registros.setBounds(710,400,130,30);
        registros.setFont(new Font("calibri",2,18));
        add(registros);
        
        
        //********************************************************************
        //                          boton Registrarse
        //*******************************************************************
        boRegistrarte.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                removeAll();
                updateUI(); // actualizar la interfaz de usuario
                
                meEmergente.removeAll();
                add(regis.Componente());
                
            }// fin del actionperformed

        });// fin del boton Registrarse
        
        
        //********************************************************************
        //                          boton Salir
        //*******************************************************************
        boSalir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                System.exit(0);
                
            }// fin del actionperformed

        });// fin del boton salir
        
        
        registros.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent even){
		removeAll();
                updateUI();
                meEmergente.removeAll();
                add(tabla.componentes());
            }
	});// fin de un boton
        
        
        
        JSeparator nu2 = new JSeparator();
        JSeparator nu3 = new JSeparator();
        
                                
        
        JMenuItem btnTAbla = new JMenuItem("Tabla de registrados");
        btnTAbla.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                removeAll();
                updateUI();
                meEmergente.removeAll();
                DatosPersona dar = new DatosPersona();
                add(dar.componentes());
                
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
                meEmergente.removeAll();
                EliminarPersona prin = new EliminarPersona();

                add(prin.conponente());
                
                
            }
            
        });
                    
        
        
        meEmergente.add(btnTAbla);
        meEmergente.add(nu2);
        meEmergente.add(btnbuscar);
        meEmergente.add(nu3);
        meEmergente.add(eliminarPerso);

        
        
        setComponentPopupMenu(meEmergente);
        
        return this;
    }

    
    
}
