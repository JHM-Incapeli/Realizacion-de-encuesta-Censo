
package Formulario;

/**
 *@Autor
 *          JAVIER ANDRES HERRERA MANJARREZ
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class DatosPersona extends JPanel{
    
    VeriFicacion veri = new VeriFicacion();
    JScrollPane scrull;
    //DefaultTableModel modelo;
    JTable tabla;
    

    public DatosPersona() {
        setLayout(null);
        setBounds(0,0,900,500);
        setBackground(new Color(213,233,253));
    }
    
    //**********************************************************************************
    //                   panel de la tabla
    public JPanel componentes() {

        tabla = new JTable();
        setBackground(new Color(0, 92, 255));

        JPanel panelDeArriva = new JPanel();
        panelDeArriva.setBounds(0, 0, 900, 100);
        panelDeArriva.setBackground(new Color(0, 92, 255));
        panelDeArriva.setBorder(BorderFactory.createLineBorder(new Color(0, 92, 255)));
        panelDeArriva.setLayout(null);
        add(panelDeArriva);

        JButton btnBack = new JButton("Menú");
        btnBack.setBounds(74, 29, 90, 41);
        btnBack.setFont(new Font("calibri", 2, 20));
        btnBack.setBackground(new Color(255, 211, 180));
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent even) {
                removeAll();
                updateUI();

                Principal prin = new Principal();

                add(prin.Componente());
            }
        });// fin de un boton
        panelDeArriva.add(btnBack);
        
        
        JButton btnEliminar = new JButton("Eliminar una persona");
        btnEliminar.setBounds(600, 29, 180, 41);
        btnEliminar.setFont(new Font("calibri", 2, 20));
        btnEliminar.setBackground(new Color(255,15,84));
        btnEliminar.setBorder(BorderFactory.createLineBorder(new Color(255,15,84)));
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent even) {
                Icon icon = new ImageIcon(getClass().getResource("/imagenes/eliminadoArchivo.png"));
                JOptionPane.showMessageDialog(null,"Los datos borrados"
                                           +"\n no seran recuperables ","Alerta",JOptionPane.DEFAULT_OPTION,icon);
                removeAll();
                updateUI();
                
                EliminarPersona prin = new EliminarPersona();

                add(prin.conponente());
            }
        });// fin de un boton
        panelDeArriva.add(btnEliminar);
        
        JButton btnBuscar = new JButton("Buscar persona");
        btnBuscar.setBounds(300,29,180,40);
        btnBuscar.setFont(new Font("calibri",2,20));
        btnBuscar.setBackground(new Color(6,166,94));
        btnBuscar.setBorder(BorderFactory.createLineBorder(new Color(6,166,40)));
        btnBuscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ee){
                
                removeAll();
                updateUI();
                
                BuscarPersona eee =new BuscarPersona();
                add(eee.conponentes());
            }
        });
        panelDeArriva.add(btnBuscar);
        
        
        
        
        tabla = (JTable) veri.nuevaTabla();
        
        scrull = new JScrollPane(/*tabla,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS*/);
        scrull.setViewportView(tabla);
        scrull.setBounds(0, 101, 885, 360);   
        add(scrull);
        
        
        
        JPopupMenu meEmergente = new JPopupMenu();
        JSeparator nu1 = new JSeparator();
        JSeparator nu2 = new JSeparator();
        JSeparator nu3 = new JSeparator();
        JSeparator nu4 = new JSeparator();
        JSeparator nu5 = new JSeparator();
        JSeparator nu6 = new JSeparator();
        JSeparator nu7 = new JSeparator();
        JSeparator nu8 = new JSeparator();
        
                                
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
        btnTAbla.setForeground(Color.black);
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
        btnbuscar.setForeground(Color.black);
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
        eliminarPerso.setForeground(Color.black);
        eliminarPerso.addActionListener((ActionEvent e) -> {
            removeAll();
            updateUI();
            
            EliminarPersona prin = new EliminarPersona();
            
            add(prin.conponente());
            
            meEmergente.removeAll();
        });
        
        JMenu Otros = new JMenu("Otros");
        Otros.setForeground(Color.black);
        JMenuItem elimiFila = new JMenuItem("Eliminar fila seleccionada");
        
        elimiFila.setForeground(Color.red);
        elimiFila.setFont(new Font("Arial",1,14));
        elimiFila.addActionListener((ActionEvent eve) ->{
            int filas= tabla.getSelectedRow();
            if(filas==-1){
                JOptionPane.showMessageDialog(null,"Debes seleccionar el trabajador a borrar");
            }else{
                
                veri.elimiNarFila(filas);
                tabla = (JTable) veri.nuevaTabla();
                
                scrull.setViewportView(tabla);
                tabla.setComponentPopupMenu(meEmergente);
            }
            
        });
        
        JMenuItem editaDatos = new JMenuItem("Editar fila seleccionada");
        editaDatos.setForeground(Color.green);
        editaDatos.setFont(new Font("Arial",1,14));
        editaDatos.addActionListener((ActionEvent eve) ->{
            int filas= tabla.getSelectedRow();
            if(filas==-1){
                JOptionPane.showMessageDialog(null,"Debes seleccionar el trabajador a borrar");
            }else{
                
                veri.rescribirDatosDePersona(filas);
                
                tabla = (JTable) veri.nuevaTabla();
                scrull.setViewportView(tabla);
                tabla.setComponentPopupMenu(meEmergente);
            }
            
        });
        JMenuItem primerOrden = new JMenuItem("Ordenar Alfabético");
        primerOrden.setForeground(Color.BLACK);
        primerOrden.addActionListener((ActionEvent evv) ->{
            int dato = 1;
            veri.ordenarDatos(dato);
            tabla = (JTable) veri.nuevaTabla();
                
            scrull.setViewportView(tabla);
            tabla.setComponentPopupMenu(meEmergente);
            
        });
        
        
        
        JMenuItem segundoOrden = new JMenuItem("Invertir orden Alfabético");
        segundoOrden.setForeground(Color.BLACK);
        segundoOrden.addActionListener((ActionEvent even) ->{
            int dato = 2;
            veri.ordenarDatos(dato);
            tabla = (JTable) veri.nuevaTabla();
                
            scrull.setViewportView(tabla);
            tabla.setComponentPopupMenu(meEmergente);
        });
        
        JMenuItem tercerOrden = new JMenuItem("Orden g...l...c.");
        tercerOrden.setForeground(Color.BLACK);
        tercerOrden.addActionListener((ActionEvent even) ->{
            int dato = 3;
            veri.ordenarDatos(dato);
            tabla = (JTable) veri.nuevaTabla();
                
            scrull.setViewportView(tabla);
            tabla.setComponentPopupMenu(meEmergente);
        });
        
        Otros.add(elimiFila);
        Otros.add(nu5);
        Otros.add(editaDatos);
        Otros.add(nu6);
        Otros.add(primerOrden);
        Otros.add(nu7);
        Otros.add(segundoOrden); 
        Otros.add(nu8);
        Otros.add(tercerOrden);
        
        meEmergente.add(btnMenus);
        meEmergente.add(nu1);
        meEmergente.add(btnTAbla);
        meEmergente.add(nu2);
        meEmergente.add(btnbuscar);
        meEmergente.add(nu3);
        meEmergente.add(eliminarPerso);
        meEmergente.add(nu4);
        meEmergente.add(Otros);

        setComponentPopupMenu(meEmergente);

        tabla.setComponentPopupMenu(meEmergente);
        scrull.setComponentPopupMenu(meEmergente);
        return this;
    }// fin de lpanel tabla

}
